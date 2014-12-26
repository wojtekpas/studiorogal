package com.gruby.sr.view;

import com.gruby.sr.entities.Article;
import com.gruby.sr.services.StudioRogalService;
import com.gruby.sr.services.UserService;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 *
 * @author ja
 */
@ViewScoped
@ManagedBean
@Log
public class EditArticle implements Serializable {

    @EJB
    StudioRogalService studioRogalService;
    
    @EJB
    UserService userService;

    @Getter
    @Setter
    private int articleId;
    
    @Getter
    @Setter
    private Article article;

    public void init() {
        if (article == null && articleId != 0) {           
            article = studioRogalService.findArticle(articleId);
        } else if (article == null && articleId == 0) {
            article = new Article();
            article.setUserId(userService.getCurrentUser());
            return;
        }
        if (article == null || userService.checkIsOwnerArticle(article) == false) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error/404.xhtml");
            } catch (IOException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        }        
    }

    public String saveArticle() {
        studioRogalService.saveEntityElement(article);
        return "list_articles?faces-redirect=true";
    }
}
