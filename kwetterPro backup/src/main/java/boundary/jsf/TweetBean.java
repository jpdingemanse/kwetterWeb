/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.jsf;

import domain.HelloUser;
import domain.Tweet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.TweetService;
import service.UserService;

/**
 *
 * @author Jean Paul
 */
@Named
@SessionScoped
public class TweetBean implements Serializable{
    private List<Tweet> searchResult = new ArrayList<>();
    @Inject
    private TweetService tweetService;
    
    public TweetBean(){
        
    }
     
   
}
