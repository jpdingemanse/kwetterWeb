/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import dao.UserDao;
import domain.Tweet;
import domain.HelloUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author 878550
 */
@Stateless
public class UserService {

    @Inject
    UserDao cd;

    public List<HelloUser> allUsers() {
        return cd.FindAll();
    }
    
    public HelloUser UserByEmail(String email){
        return cd.FindByEmail(email);
    }
    public HelloUser UserByName(String name){
        return cd.FindByName(name);
    }

    public HelloUser UserById(Long id) {
       return cd.FindById(id); 
    }

   public void setDao(UserDao userDao) {
        this.cd = userDao;
    }
   
   public HelloUser createUser(HelloUser user) {
        return cd.Create(user);
    }

    public List<Tweet> getTimelineTweets(String userid) {
        return cd.getTimelineTweets(userid);
    }

    
    
    

}
