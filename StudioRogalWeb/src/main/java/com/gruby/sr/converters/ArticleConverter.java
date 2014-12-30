package com.gruby.sr.converters;

import com.gruby.sr.entities.Article;
import com.gruby.sr.services.ArticleService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
/**
*
* @author ja
*/

@ManagedBean
@RequestScoped
public class ArticleConverter implements Converter {
    
    @EJB
    private ArticleService articleService;
    
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ("---".equals(value)) {
            return null;
        }
        return articleService.findArticle(Integer.parseInt(value));
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "---";
        }
        return ((Article) value).getId() + "";
    }
}