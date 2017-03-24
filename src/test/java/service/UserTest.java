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
public class UserTest {
    
    UserService uService;
    @Mock
    UserDao userDao;
    

    
    HelloUser user;

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        uService = new UserService();
        uService.setDao(userDao);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void TestUser(){
       user = new HelloUser( "user1", "test");
       uService.createUser(user);
       
       verify(userDao, Mockito.times(1)).Create(user);
    }
}

