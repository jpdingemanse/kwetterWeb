/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Role;
import domain.Tweet;
import domain.HelloUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

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
    
    
    public HelloUser Create(HelloUser user) {
       try{
           em.persist(user);
           em.flush();
           return user;
        }catch (Exception e) {
            return null;
        }
    }

    
    public void Edit(HelloUser user) {
        em.merge(user);
    }

    
    public List<HelloUser> FindAll() {
        return em.createNamedQuery("HelloUser.all").getResultList();
    }

    
    public void Remove(HelloUser user) {
        em.remove(user);
    }

    
    public HelloUser FindByName(String name) {
        return (HelloUser) em.createNamedQuery("HelloUser.findByName").setParameter("name", name).getSingleResult();      
    }

    
    public HelloUser FindByEmail(String email) {
        return (HelloUser) em.createNamedQuery("HelloUser.findByEmail").setParameter("email", email).getSingleResult();      
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    
    public HelloUser FindById(Long id) {
        return (HelloUser) em.createNamedQuery("HelloUser.findById").setParameter("id", id).getSingleResult();
    }

    public Boolean addFollowing(int i, int i0) {
    try {
            HelloUser user =  getProfileById(i);
            HelloUser following  = getProfileById(i0);
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

    private HelloUser getProfileById(int id) {
        try{
            Long longId = new Long(id);
            return em.find(HelloUser.class, longId);
        }catch (Exception e){
            return null;

        }
    }

    public List<HelloUser> getFollowing(int userId) {
          try{
            List<HelloUser> result = getProfileById(userId).getFollowing();
            return result;
        }
        catch (Exception e){
            return null;
        }
    }
    
    public List<Tweet> getTimelineTweets(String userid){
        StoredProcedureQuery query = this.em.createStoredProcedureQuery("gettimeline", Tweet.class);
        query.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);
        //query.setParameter("id", userid);
        query.execute();
        return (List<Tweet>) query.getParameterValue("result");
    }

}
