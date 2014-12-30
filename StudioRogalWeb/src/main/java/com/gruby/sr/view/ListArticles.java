package com.gruby.sr.view;

import com.gruby.sr.entities.Article;
import com.gruby.sr.services.ArticleService;
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
    ArticleService articleService;
    
    private List<Article> articles;
    
    public List<Article> getArticles() {
        if (articles == null) {
            articles = articleService.findAllArticles();
        }
        return articles;
    }

    public void removeArticle(Article article) {
        articleService.removeEntityElement(article);
        articles.remove(article);
    }
}
