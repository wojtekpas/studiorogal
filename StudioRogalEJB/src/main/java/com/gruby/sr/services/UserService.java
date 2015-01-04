/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruby.sr.services;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.gruby.sr.entities.Article;
import com.gruby.sr.entities.User;
import com.gruby.sr.interfaces.EntityElement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
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
public class UserService {

    @PersistenceContext(unitName = "SR_PU")
    EntityManager em;
    
    @Resource
    SessionContext sctx;
    
    @RolesAllowed({"Admin", "User"})
    public boolean checkIsOwnerArticle(Article article){
        if (sctx.isCallerInRole("Admin"))
            return true;
        
        return getCurrentUser().equals(article.getUserId());
    }

    @RolesAllowed({"Admin", "User"})
    public User getCurrentUser(){        
        return findUser(sctx.getCallerPrincipal().getName());
    }
    
    @RolesAllowed({"Admin", "User"})
    public List<User> findAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }
    
    @RolesAllowed({"Admin", "User"})
    public List<User> findUsers() {
        if (sctx.isCallerInRole("Admin")){
            return em.createNamedQuery("User.findAll").getResultList();        
        }
        List<User> users = new ArrayList<>();
        users.add(getCurrentUser());
        
        return users;
    }    
    
    @RolesAllowed({"Admin", "User"})
    public User findUser(int id) {
        return em.find(User.class, id);
    }
    
    @RolesAllowed({"Admin", "User"})
    public User findUser(String login) {
        return (User)em.createNamedQuery("User.findByLogin").setParameter("login",login).getSingleResult();
    }
    
    @RolesAllowed({"Admin", "User"})
    public void saveUsers(List<User> users){
        if (sctx.isCallerInRole("Admin")){
            for (User user : users)
                saveUserWithPassword(user);          
        } else {
            saveUserWithPassword(getCurrentUser());
        }
    }
    
    private void saveUserWithPassword(User user){
        if ("".equals(user.getPassword()))
            return;
        
        user.setPassword(Hashing.sha256().hashString(user.getPassword(), Charsets.UTF_8).toString());
        em.merge(user);
    }
    
    public void saveUser(User user) {
        if(user.getId() == null){
            em.persist(user);
            saveUserWithPassword(user);
        }else{
            em.merge(user);
        }
    }
    
    public void removeUser(User user) {
        em.remove(em.merge(user));
    }
}
