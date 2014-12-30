package com.gruby.sr.view;

import com.gruby.sr.entities.Article;
import com.gruby.sr.entities.Comment;
import com.gruby.sr.services.ArticleService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
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
public class ViewArticle implements Serializable {

    @EJB
    ArticleService articleService;

    @Getter
    @Setter
    private int articleId;

    @Getter
    @Setter
    private Article article;
    
    private List<Comment> comments;  
    
    public void init() {
        if (article == null) {
            article = articleService.findArticle(articleId);
        }
        if (article == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error/404.xhtml");
            } catch (IOException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    public List<Comment> getComments(){
        if(comments == null){
            comments = articleService.findCommentsForArticle(article);
            //System.out.println(comments.size());
        }
        return comments;
    }
}
