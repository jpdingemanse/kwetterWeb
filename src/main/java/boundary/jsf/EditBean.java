/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jsf;

import domain.HelloUser;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import service.UserService;

/**
 *
 * @author Jean Paul
 */
@Named
@ManagedBean
@ViewScoped
public class EditBean {
    private boolean showEdit;
    private HelloUser user = new HelloUser();
    private String usernameProfile;
    private HelloUser userProfile = new HelloUser(); 
    
     @Inject
    private UserService userService;
     
    public EditBean()
    {}
  
    public boolean isShowEdit() {
        if (user.getName().equals(usernameProfile)){
            return true;
        } 
        return false;
    }

    public void setShowEdit(boolean showEdit) {
        this.showEdit = showEdit;
    }

    public HelloUser getUser() {
        return user;
    }

    public void setUser(HelloUser user) {
        this.user = user;
    }

    public String getUsernameProfile() {
        return usernameProfile;
    }

    public void setUsernameProfile(String usernameProfile) {
        this.usernameProfile = usernameProfile;
    }

    public HelloUser getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(HelloUser userProfile) {
        this.userProfile = userProfile;
    }
    
    public void replaceFields(){
        //TODO set editfield visible
    }
    
     public HelloUser setSelectedUser() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String username = request.getRemoteUser();
        if (username != null) {
            user = userService.UserByName(username);
        }
       
        return user;
    }
     public HelloUser loadUserForProfile(){
        if (this.usernameProfile != null) {
            userProfile = userService.UserByName(usernameProfile);
        }
        else {
            System.out.println("Username is empty");
        }
       
        return userProfile;
    }
}
