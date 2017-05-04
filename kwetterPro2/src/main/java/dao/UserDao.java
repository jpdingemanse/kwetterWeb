/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Role;
import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jean Paul
 */
@Stateless
public class UserDao {

    @PersistenceContext
    EntityManager em;
   
    public UserDao(){
        
    }
    
     public UserDao(EntityManager em){
        this.em = em;
    }
    
    
    public User Create(User user) {
       try{
           em.persist(user);
           em.flush();
           return user;
        }catch (Exception e) {
            return null;
        }
    }

    
    public void Edit(User user) {
        em.merge(user);
    }

    
    public List<User> FindAll() {
        return em.createNamedQuery("User.all").getResultList();
    }

    
    public void Remove(User user) {
        em.remove(user);
    }

    
    public User FindByName(String name) {
        User user = (User)em.createQuery(
        "SELECT u FROM USER u WHERE u.name LIKE :uName")
        .setParameter("uName", name);
        if (user == null){
            throw new EntityNotFoundException("Can't find user for name "
                    + name);
        }
        return user;
        
      
    }

    
    public User FindByEmail(String email) {
        User user = (User)em.createQuery(
        "SELECT u FROM USER u WHERE u.name LIKE :uEmail")
        .setParameter("uEmail", email);
        if (user == null){
             throw new EntityNotFoundException("Can't find User for email "
                    + email);
        }
        return user;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    
    public User FindById(Long id) {
        return (User) em.createNamedQuery("User.findById").setParameter("id", id).getSingleResult();
    }

    public Boolean addFollowing(int i, int i0) {
    try {
            User user =  getProfileById(i);
            User following  = getProfileById(i0);
            boolean check = user.addFollowing(following);
            if(check){
                em.merge(user);
                return true;
            }
            return false;
            
        }
        catch(Exception e) {
            return false;
        }
    }

    private User getProfileById(int id) {
        try{
            Long longId = new Long(id);
            return em.find(User.class, longId);
        }catch (Exception e){
            return null;

        }
    }

    public List<User> getFollowing(int userId) {
          try{
            List<User> result = getProfileById(userId).getFollowing();
            return result;
        }
        catch (Exception e){
            return null;
        }
    }

}
