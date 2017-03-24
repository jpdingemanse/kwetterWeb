/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import dao.GroupDao;
import dao.RoleDao;
import dao.UserDao;
import dao.TweetDao;
import domain.Group;
import domain.Role;
import domain.Tweet;
import domain.HelloUser;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 878550
 */
@Singleton
@Startup
@PermitAll
public class Init {
    
    @Inject
    UserDao ud;
    
    @Inject
    RoleDao rd;
    
    @Inject
    TweetDao td;
    
    @Inject
    GroupDao gd;
    
    
    @PostConstruct
    public void init(){
        HelloUser user1 = new HelloUser("jp", stringToHash("jp"));//"test");
        HelloUser user2= new HelloUser("user", stringToHash("user"));   

        ud.Create(user1);
        ud.Create(user2);
        Role role = new Role("Regular");
        Role role1 = new Role("Admin");
        rd.Create(role);
        rd.Create(role1);
        
        Group group1 = new Group("Admin");
        Group group2 = new Group("Regular");
        gd.Create(group1);
        gd.Create(group2);
        
        List<HelloUser> userList = new ArrayList<>();
        userList.add(user1);
        role1.setUser_role(userList);
        
        List<HelloUser> UserList1 = new ArrayList<>();
        UserList1.add(user1);
        role1.setUser_role(UserList1);
        
        rd.addRoleToUser(role1);
        rd.addRoleToUser(role1);
        
        ud.addFollowing(1, 2);
        ud.addFollowing(2, 1);
        
        Tweet t1 = new Tweet("tweet", new Date(11, 2, 2), user1);
        td.Create(t1);
        Tweet t2 = new Tweet("tweet twee", new Date(11, 2, 2), user2);
        td.Create(t2);
        
    
    }

    public static String stringToHash(String input) {
        String output = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(input.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            output = bigInt.toString(16);

            //System.out.println(output);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger("Init").log(Level.SEVERE, null, ex);
        }
        return output;
    }
}