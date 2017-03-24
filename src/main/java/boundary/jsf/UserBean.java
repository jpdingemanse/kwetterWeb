/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jsf;

import domain.Tweet;
import domain.HelloUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.SessionScoped;
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
@SessionScoped
public class UserBean implements Serializable {
    private String welcome = "hi User";
    private List<HelloUser> users = new ArrayList<>();
    private List<Tweet> timelineTweets = new ArrayList<>();
    
    @Inject
    private UserService userService;
    
    public UserBean(){
        
    }
   
    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public List<HelloUser> getUsers() {
        return users;
    }

    public void setUsers(List<HelloUser> users) {
        this.users = users;
    }

    public List<Tweet> getTimelineTweets() {
        return timelineTweets;
    }

    public void setTimelineTweets(List<Tweet> timelineTweets) {
        this.timelineTweets = timelineTweets;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    
    public String fillList(){
        this.users.addAll(userService.allUsers());
        return "";
    }
    
    public String clearList(){
        this.users.clear();
        return "";
    }
    
    public void getTimeline(){
        timelineTweets = userService.getTimelineTweets(setSelectedUser().getId().toString());
//        try {
//            this.users.clear();
//            this.users.addAll(userService.allUsers());
//                for (Iterator<HelloUser> iterator = users.iterator(); iterator.hasNext();) {
//                    HelloUser nextUser = iterator.next();
//                    System.out.println(nextUser.getName());
//                    for (Iterator<Tweet> iterator2 = nextUser.getTweets().iterator(); iterator2.hasNext();){
//                        Tweet nextTweet = iterator2.next();
//                         System.out.println(nextTweet.getMessage());
//                        followingTweets.add(nextTweet);
//                    }
//
//                }
//            } catch (Exception e) {
//                
//            }
//        return null;
    }
    
    public String refreshTimeline(){
        this.timelineTweets.clear();
        getTimeline();
        return "";
    }
    
    /**
     * @return the selectedUser
     */
    public HelloUser setSelectedUser() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String username = request.getRemoteUser();
        System.err.println(username);

        HelloUser t = null;
        if (username != null) {
            t = userService.UserByName(username);
        }
        return t;
    }
    
}
