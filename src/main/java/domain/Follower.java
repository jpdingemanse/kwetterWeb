/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jean Paul
 */
@Entity
@NamedQueries({
 @NamedQuery(name = "Followers.all", query = "SELECT f FROM Follower f WHERE f.followedId = :id"),
})
public class Follower implements Serializable{
    @Id
    private int followedId;
    private int followingId;
    
    public Follower(){
    
    }
    
    public Follower(int followedId, int followingId){
        this.followedId = followedId;
        this.followingId= followingId;
    }

    public int getFollowedId() {
        return followedId;
    }

    public void setFollowedId(int followedId) {
        this.followedId = followedId;
    }

    public int getFollowingId() {
        return followingId;
    }

    public void setFollowingId(int followingId) {
        this.followingId = followingId;
    }
    
    
}