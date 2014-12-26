package com.gruby.sr.view;

import com.gruby.sr.entities.Article;
import com.gruby.sr.services.StudioRogalService;
import com.gruby.sr.entities.Comment;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ja
 */
@ViewScoped
@ManagedBean
public class ListArticles implements Serializable {
    
    @EJB
    StudioRogalService studioRogalService;
    
    private List<Article> articles;
    
    public List<Article> getArticles() {
        if (articles == null) {
            articles = studioRogalService.findArticles();
        }
        return articles;
    }

    public void removeArticle(Article article) {
        studioRogalService.removeEntityElement(article);
        articles.remove(article);
    }
}
