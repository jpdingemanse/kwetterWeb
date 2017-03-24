/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import dao.TweetDao;
import domain.Tweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author 878550
 */
@Stateless
public class TweetService {

   

    @Inject
    TweetDao cd;
    
    

    public List<Tweet> allTweets() {
        return cd.FindAll();
    }

    public Tweet getTweet(Long id) {
        return cd.find(id);
    }
    
    public Tweet createTweet(Tweet tweet) {
        return cd.Create(tweet);
    }
    public void setDao(TweetDao tweetDao) {
        this.cd = tweetDao;
    }
    
//     public List<Tweet> loadTweetsUser(String userName) {
//        
//        return cd.LoadTweetsUser(userName);
//    }
    
   

}
