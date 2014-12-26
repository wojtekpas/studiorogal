package com.gruby.sr.view;

import com.gruby.sr.entities.User;
import com.gruby.sr.services.UserService;
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
public class ListUsers implements Serializable {

    @EJB
    UserService userService;

    private List<User> users;
    
    public List<User> getUsers() {
        if (users == null) {
            users = userService.findUsers();
        }
        return users;
    }
    
    public void save(){
        userService.saveUsers(users);
    }
}