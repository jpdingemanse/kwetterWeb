/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import dao.UserDao;
import dao.TweetDao;
import dao.RoleDao;
import org.junit.Test;
import domain.HelloUser;
import domain.Role;
import domain.Tweet;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Jean Paul
 */
@RunWith(MockitoJUnitRunner.class)
public class TweetTest {
    
    TweetService tService = new TweetService();


    
    @Mock
    TweetDao tweetDao;
    HelloUser user;
    Tweet tweet;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {        
       
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void TestTweet(){
       tService.setDao(tweetDao);
       user = new HelloUser( "jp2", "test");
       tweet = new Tweet("Test tweets", new Date(1, 1, 1), user);
       tService.createTweet(tweet);
       
       verify(tweetDao, Mockito.times(1)).Create(tweet);
    }
    
    
}

