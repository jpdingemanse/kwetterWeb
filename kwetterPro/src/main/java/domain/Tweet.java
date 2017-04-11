/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jean Paul
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Tweet.all", query = "SELECT t FROM Tweet t"),
    @NamedQuery(name = "Tweet.findById", query = "SELECT t FROM Tweet t WHERE t.id = :id"),
    @NamedQuery(name = "Tweet.LoadTweetsUser", query = "SELECT t FROM Tweet t WHERE t.user.id = :id"),
   // @NamedQuery(name = "Tweet.TimelineTweets", query = "select t from tweet t LEFT join hellouser_hellouser h on t.user_id = h.following_ID LEFT join hellouser u on u.ID = h.HelloUser_ID where u.id = :userid")
})
public class Tweet implements Serializable{

   
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

   
    
    @ManyToOne
    private HelloUser user;
    
    private String message;
    private Date time; 
    //List<User> hearts; //OPTIONEEL
    public Tweet(){
        
    }
    
    public Tweet(String message, Date time, HelloUser user){
        this.message = message;
        this.time = time;
        this.user = user;
        
    }
    
    public Tweet getTweet(){
        return this;
    }
    
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    //OPTIONEEL
//    public List<User> getHearts() {
//        return hearts;
//    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tweet other = (Tweet) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }

    public HelloUser getTweeter() {
        return user;
    }
    
     public void setTweeter(HelloUser user) {
         this.user= user;
    }

    @Override
    public String toString() {
        return "Tweet{" + "id=" + id + ", user=" + user + ", message=" + message + ", time=" + time + '}';
    }
     
}

