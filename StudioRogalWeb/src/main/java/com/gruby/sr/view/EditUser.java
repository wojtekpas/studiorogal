/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruby.sr.view;

import com.gruby.sr.entities.User;
import com.gruby.sr.enums.Roles;
import com.gruby.sr.services.ArticleService;
import com.gruby.sr.services.UserService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
public class EditUser implements Serializable {

    @EJB
    UserService userService;

    @Getter
    @Setter
    private User user;
        
    @Getter
    @Setter
    private int userId;
    
    private List<SelectItem> rolesAsSelectItems;
    
    @Getter
    @Setter
    private String repeatPassword;

    public void init() {
        if (user == null && userId != 0) {
            user = userService.findUser(userId);
        } else if (user == null && userId == 0) {
            user = new User();
            return;
        }
        if (user == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error/404.xhtml");
            } catch (IOException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    public List<SelectItem> getRolesAsSelectItems() {
        if (rolesAsSelectItems == null) {
            rolesAsSelectItems = new ArrayList<>();
            for (Roles role : Roles.values()) {
                rolesAsSelectItems.add(new SelectItem(role,role.name()));
            }
        }
        return rolesAsSelectItems;
    }

    public String saveUser() {
        userService.saveUser(user);
        return "index?faces-redirect=true";
    }
}
