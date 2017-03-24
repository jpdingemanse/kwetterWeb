/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Role;
import domain.Tweet;
import domain.HelloUser;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jean Paul
 */
public class TweetTest {
   
    private EntityManager em;
    private EntityTransaction et;
    
    Tweet tweet;
    Tweet tweet1;
    Tweet tweet2;
    HelloUser user;

    TweetDao tDAO;
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        HelloUser user = new HelloUser("test", "tets");
        tweet  = new Tweet("A tweet", new Date(1, 1, 1),user);
        tweet1  = new Tweet("another tweet", new Date(1, 1, 1), user);
        tweet2  = new Tweet("last tweet", new Date(1, 1, 1),user);
        
//        em = emf.createEntityManager();
//        et = em.getTransaction();
//        TweetDao tweetDao = new TweetDao();
    }
    
 
    @Test
    public void TweetDaoTest(){
//        et.begin();
//        tDAO.Create(tweet);
//        tDAO.Create(tweet1);
//        tDAO.Create(tweet2);
//        et.commit();
//        
//        Assert.assertNotNull(tDAO);
//        List<Tweet> tweets = tDAO.FindAll();
//        Assert.assertNotNull(tweets);
//        Assert.assertEquals(3, tweets.size());

    }
}

