/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jsf;

import domain.Follower;
import domain.Tweet;
import domain.HelloUser;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import service.TweetService;
import service.UserService;

/**
 *
 * @author Jean Paul
 */
@Named
@SessionScoped
public class UserBean implements Serializable {

    private HelloUser user = new HelloUser();
    private String usernameProfile;
    private HelloUser userProfile = new HelloUser();
    
    private String editUsername;
    private String editBio;
    private String editEmail;
    private List<Follower> followers;
   
    private List<Tweet> timelineTweets = new ArrayList<>();
    private List<Tweet> searchResult = new ArrayList<>();
    @Inject
    private TweetService tweetService;
    @Inject
    private UserService userService;
    
    private boolean showEdit;
    
    
    
    public UserBean(){
        
    }

    

    public List<Follower> getFollowers() {
        followers = user.getFollowers();
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public List<Tweet> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Tweet> searchResult) {
        this.searchResult = searchResult;
    }

    public TweetService getTweetService() {
        return tweetService;
    }

    public void setTweetService(TweetService tweetService) {
        this.tweetService = tweetService;
    }
    

    public HelloUser getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(HelloUser userProfile) {
        this.userProfile = userProfile;
    }

     public String getUsernameProfile() {
        return usernameProfile;
    }

    public void setUsernameProfile(String usernameProfile) {
        
        this.usernameProfile = usernameProfile;
    }
    public HelloUser getUser() {
        return user;
    }

    public void setUser(HelloUser user) {
        this.user = user;
    }

    public List<Tweet> getTimelineTweets() {

        setTimelineTweets();
        return timelineTweets;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getEditUsername() {
        return editUsername;
    }

    public void setEditUsername(String editUsername) {
        this.editUsername = editUsername;
    }

    public String getEditBio() {
        return editBio;
    }

    public void setEditBio(String editBio) {
        this.editBio = editBio;
    }

    public String getEditEmail() {
        return editEmail;
    }

    public void setEditEmail(String editEmail) {
        this.editEmail = editEmail;
    }
    
    

    public List<Tweet> setSearchResultToTimeline(List<Tweet> searchResult){
        timelineTweets.clear();
        timelineTweets = searchResult;
        return timelineTweets;
    }
    
    public List<Tweet> setTimelineTweets(){
        timelineTweets.clear();
        setSelectedUser();
        List<HelloUser> allUsersTimeline = new ArrayList<HelloUser>();
        allUsersTimeline = user.getFollowing();
        allUsersTimeline.add(user);
        for (HelloUser u : allUsersTimeline){    
            List<Tweet> tweets = u.getTweets();
            for (Tweet t : tweets){
                timelineTweets.add(t);
            }
        }
        return timelineTweets;
        //timelineTweets = userService.getTimelineTweets(setSelectedUser().getId().toString());
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
    
//    public String refreshTimeline(){
//        this.timelineTweets.clear();
//        setTimelineTweets();
//        return "";
//    }
//    
    /**
     * @return the selectedUser
     */
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
    
    public void newTweet(String message){
        Tweet tweet = new Tweet(message, new Date(), user);
        userService.addTweet(user, tweet);
        setTimelineTweets();
        
    }
    
    
    
    
 public List<Tweet> search(String message){
        searchResult = tweetService.allTweets();
        List<Tweet> templist = new ArrayList<>();
        for (Tweet t : searchResult){
            if (t.getMessage().contains(message)){
                templist.add(t);
            }          
        }
        setSearchResultToTimeline(templist);
        
        return templist;
    }
 
public String logout() {
    ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
     return "login.xhtml";
}

public String profilePage(){
    return "faces/profile.xhtml";
}
    
}
