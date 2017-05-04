/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jean Paul
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "User.all", query = "SELECT u FROM User u"),
    //@NamedQuery(name = "User.findByName", query = "SELECT u from User u where u.USERNAME = :userName"),
    @NamedQuery(name = "User.findById", query = "SELECT u from User u where u.id = :id"),
    //@NamedQuery(name = "User.getFollowers", query = "SELECT DISTINCT u from User u join u.following f WHERE f.id =:u.id")
})
@Table(name = "HelloUser")
public class User {
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
    
    @ManyToMany(mappedBy = "users")
    private List<Group> groups;
    
    @OneToMany (mappedBy = "user")
    private List<Tweet> tweets;
    @ManyToMany
    private List<User> following;

    public User(){
        
    }
    public User(String username, String password){
        this.userName = username;
        this.password = password;
        tweets = new ArrayList<>();
        following = new ArrayList<>();
    }
    
    
    public User(String name, String password, String bio, String email, String location, String website, Role role) {
        this.userName = name;
        this.password = password;
        this.bio = bio;
        this.email = email;
        this.location = location;
        this.website = website;
        this.role = role;
        tweets = new ArrayList<>();
        following = new ArrayList<>();
    }
    
    public Boolean addFollowing(User user){
        try {
            if(!this.following.contains(user)){
            this.following.add(user);
            return true;
        }
        } catch (Exception ex){
            System.out.println(this.userName);
            System.out.println(user.userName);
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
    
    public void addTweet(Tweet tweet){
        tweets.add(tweet);
        tweet.setTweeter(this);
    }
    
    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
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
    
}
