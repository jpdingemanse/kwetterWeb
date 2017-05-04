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
    @NamedQuery(name = "Tweet.findbyid", query = "SELECT t from Tweet t where t.id = :id")
})
public class Tweet implements Serializable{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

   
    
    @ManyToOne()
    private User user;
    
    private String message;
    private Date time; 
    //List<User> hearts; //OPTIONEEL
    public Tweet(){
        
    }

    public Tweet(Long id, User user, String message, Date time) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.time = time;
    }
    
    public Tweet(String message, Date time){
        this.message = message;
        this.time = time;
        
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public void setMessage(String message) {
        this.message = message;
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

    public User getTweeter() {
        return user;
    }
    
    public void setTime(Date time){
        this.time = time;
    }
    
     public void setTweeter(User user) {
         this.user= user;
    }
}

