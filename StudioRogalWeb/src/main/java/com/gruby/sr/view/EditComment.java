package com.gruby.sr.view;

import com.gruby.sr.entities.Article;
import com.gruby.sr.services.ArticleService;
import com.gruby.sr.entities.Comment;
import com.gruby.sr.services.UserService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
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
public class EditComment implements Serializable {

    @EJB
    ArticleService articleService;
    
    @EJB
    UserService userService;
    
    @Getter
    @Setter
    private int articleId;

    @Getter
    @Setter
    private int commentId;
    
    @Getter
    @Setter
    private Comment comment;

    public void init() {
        if (comment == null && commentId != 0) {
            comment = articleService.findComment(commentId);
        } else if (comment == null && commentId == 0) {
            comment = new Comment();
            comment.setArticleId(articleService.findArticle(articleId));
            comment.setUserId(userService.getCurrentUser());
            return;
        }
        if (comment == null || userService.checkIsOwnerArticle(comment.getArticleId()) == false) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error/404.xhtml");
            } catch (IOException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        }
    }

    public String saveComment() {
        articleService.saveEntityElement(comment);
        String s= "view_article?articleId="+articleId+"&faces-redirect=true";
        return s;
    }
}
