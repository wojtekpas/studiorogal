/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruby.sr.services;

import com.gruby.sr.entities.Article;
import com.gruby.sr.entities.Comment;
import com.gruby.sr.interfaces.EntityElement;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.java.Log;

/**
 *
 * @author ja
 */

@Stateless
@LocalBean
@Log
@DeclareRoles(value = {"Admin", "User"})
public class ArticleService {

    @PersistenceContext(unitName = "SR_PU")
    EntityManager em;

    @Resource
    SessionContext sctx;

    @EJB
    UserService userService;
    
    @RolesAllowed({"Admin", "User"})
    public void saveEntityElement(EntityElement elem) {
        if(elem.getId() == 0){
            em.persist(elem);
        }else{
            em.merge(elem);
        }
    }
    
    @RolesAllowed({"Admin", "User"})
    public void removeEntityElement(EntityElement elem) {
        em.remove(em.merge(elem));
    }

    @RolesAllowed({"Admin", "User"})
    public List<Article> findAllArticles() {
        return em.createNamedQuery("Article.findAll").getResultList();
    }

    @RolesAllowed({"Admin", "User"})
    public Article findArticle(int id) {
        return em.find(Article.class, id);
    }
    
    @RolesAllowed({"Admin", "User"})
    public List<Comment> findAllComments() {
        return em.createNamedQuery("Comment.findAll").getResultList();
    }
    
    @RolesAllowed({"Admin", "User"})
    public List<Comment> findCommentsForArticle(Article article) {
        List<Comment> comments = em.createNamedQuery("Comment.findByArticleId").setParameter("articleId", article).getResultList();
        System.out.println(comments.size());
        
        return comments;
    }
    
    @RolesAllowed({"Admin", "User"})
    public Comment findComment(int id) {
        return em.find(Comment.class, id);
    }
}