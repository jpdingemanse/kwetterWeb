/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import dao.TweetDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.persistence.annotations.Direction;
import service.TweetService;

/**
 *
 * @author Jean Paul
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "HelloUser.all", query = "SELECT u FROM HelloUser u"),
    @NamedQuery(name = "HelloUser.findByName", query = "SELECT u FROM HelloUser u WHERE u.userName = :name"),
    @NamedQuery(name = "HelloUser.findByEmail", query = "SELECT u FROM HelloUser u WHERE u.email = :email"),
    @NamedQuery(name = "HelloUser.findById", query = "SELECT u from HelloUser u where u.id = :id"),
   
        }) 
//@NamedStoredProcedureQuery(name="newtimeline", procedureName="EMP_READ_ALL", resultClasses=Tweet.class, parameters={
//    @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class), 
//    @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = ":followinguserid")
//})
@Table(name = "HelloUser")
public class HelloUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName; 
    private String password;
    private String bio;
    private String email;    
    private String location;
    private String website;
    private Role role;
    private String profilePic; 
     private HelloUser user = this; 
    
    @ManyToMany(mappedBy = "users")
    private List<Group> groups;
    
    @OneToMany (mappedBy = "user")
    private List<Tweet> tweets;
    @ManyToMany
    private List<HelloUser> following; 
    
    
   private List<Follower> followers;
  
 
    
    public HelloUser(){
        
    }
    public HelloUser(String username, String password){
        this.userName = username;
        this.password = password;
        tweets = new ArrayList<>();
        following = new ArrayList<>();
       followers = new ArrayList<>();
        
        

    }
    
    
    public HelloUser(String name, String password, String bio, String email, String location, String website, Role role, String profilepic) {
        this.userName = name;
        this.password = password;
        this.bio = bio;
        this.email = email;
        this.location = location;
        this.website = website;
        this.role = role;
        this.profilePic = profilepic;
        tweets = new ArrayList<>();
        following = new ArrayList<>();
        followers = new ArrayList<>();
    }
    
    public Boolean addFollowing(HelloUser user){
        
        try {
            if(!this.following.contains(user)){
            this.following.add(user);
            return true;
        }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public Boolean addFollower(Follower follower){
        try {
            if(!this.followers.contains(follower)){
            this.followers.add(follower);
            return true;
        }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Boolean addTweet(Tweet tweet){
        try {
            tweet.setTweeter(this);
            this.tweets.add(tweet);
            return true;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
       
    }
    
    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<HelloUser> getFollowing() {
        return following;
    }

    public void setFollowing(List<HelloUser> following) {
        this.following = following;
    }
    

    public void setName(String name) {
        this.userName = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getWebsite() {
        return website;
    }

    public Role getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public HelloUser getUser() {
        return user;
    }

    public void setUser(HelloUser user) {
        this.user = user;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }
    
    
}
