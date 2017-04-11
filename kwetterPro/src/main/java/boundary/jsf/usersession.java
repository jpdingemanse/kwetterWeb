/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jsf;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jean Paul
 */
public class usersession {
    
    
    public String logout() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    session.invalidate();
    return "/login.xhtml?faces-redirect=true";
}

public boolean isUserLoggedIn() {
    String user = this.getUsername();
    boolean result = !((user == null)|| user.isEmpty());
    return result;
}

/** Get the login username if it exists */
public String getUsername() {
    String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    return user;
}    
}
