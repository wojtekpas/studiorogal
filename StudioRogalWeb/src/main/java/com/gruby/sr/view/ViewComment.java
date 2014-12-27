package com.gruby.sr.view;

import com.gruby.sr.entities.Comment;
import com.gruby.sr.services.StudioRogalService;
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
public class ViewComment implements Serializable {

    @EJB
    StudioRogalService studioRogalService;
        
    @Getter
    @Setter
    private int commentId;

    @Getter
    @Setter
    private Comment comment;
    
    public void init() {
        if (comment == null) {
            comment = studioRogalService.findComment(commentId);
        }
        if (comment == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error/404.xhtml");
            } catch (IOException ex) {
                log.log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
