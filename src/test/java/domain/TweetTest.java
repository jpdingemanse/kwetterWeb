/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Jean Paul
 */
public class TweetTest {
    @Test
    public void TweetTest(){
        HelloUser user1 = new HelloUser("jp1", "jp1");
        HelloUser user2 = new HelloUser("jp1", "jp1");
        HelloUser user3 = new HelloUser("jp2", "jp2");
        //Object is not the same
        Assert.assertNotEquals("Not same object", user1, user2);
        //Object has the same name
        Assert.assertTrue(user1.getName().equalsIgnoreCase(user2.getName()));
        
        
        user1.addFollowing(user3);
        
        Assert.assertTrue(1 == user1.getFollowing().size());
        
        Tweet tweet = new Tweet("First tweet", new Date(1, 1, 1), user1);
        user1.addTweet(tweet);
        Assert.assertEquals(tweet.getTweeter(), user1);
        
        
       
        
        
        
    }
}
