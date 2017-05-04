/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import dao.UserDao;
import domain.Tweet;
import domain.User;
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

    public List<User> allUsers() {
        return cd.FindAll();
    }
    
    public User UserByEmail(String email){
        return cd.FindByEmail(email);
    }
    public User UserByName(String name){
        return cd.FindByName(name);
    }

    public User UserById(Long id) {
       return cd.FindById(id); 
    }

   public void setDao(UserDao userDao) {
        this.cd = userDao;
    }
   
   public User createUser(User user) {
        return cd.Create(user);
    }

    
    
    

}
