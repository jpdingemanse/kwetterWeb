/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.UserDao;
import dao.RoleDao;
import dao.GroupDao;
import dao.TweetDao;
import domain.Role;
import domain.Tweet;
import domain.User;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Jean Paul
 */
public class UserTest {
    
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestFactory");
    private EntityManager em;
    private EntityTransaction et;
    
    User user;
    User user1;
    User user2;
    User user3;
    List<Role> role;
    List<User> following;
    List<Tweet> tweets;
    

    UserDao uDAO;
    RoleDao rDAO;
    TweetDao tDAO;
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        user  = new User("user1",   "test");
        user1  = new User("user2", "test");
        user2  = new User("user3",  "test");
        user3  = new User("user4",  "test"); 
        
//        em = emf.createEntityManager();
//        et = em.getTransaction();
//        UserDao userDao = new UserDao();
    }
    
 
    @Test
    public void TestUserDao(){
//        UserDao userDao = new UserDao(em);
//        et.begin();
//        userDao.Create(user);
//        userDao.Create(user1);
//        userDao.Create(user2);
//        userDao.Create(user3);
//        et.commit();
//        
//        Assert.assertNotNull(userDao);
//        List<User> users = userDao.FindAll();
//        Assert.assertNotNull(users);
//        Assert.assertEquals(4, users.size());
//        
//        
//        et.begin();
//        userDao.addFollowing(1, 4);
//        userDao.getFollowing(1);
//        et.commit();
//        
//        
    }
}