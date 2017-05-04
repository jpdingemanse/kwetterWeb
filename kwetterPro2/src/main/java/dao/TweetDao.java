/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import domain.Tweet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Jean Paul
 */
@Stateless
public class TweetDao {

    @PersistenceContext
    EntityManager em; 
    
    public TweetDao(){

    }
    public TweetDao(EntityManager em){
        this.em = em;
    }
    
   // @Override
    public Tweet Create(Tweet tweet) {
        try{
           em.persist(tweet);
           em.flush();
           return tweet;
        }catch (Exception e) {
            return null;
        }
    }

    //@Override
    public void Edit(Tweet tweet) {
        em.merge(tweet);
    }

   // @Override
    public List<Tweet> FindAll() {
       return em.createNamedQuery("Tweet.all").getResultList();
    }

   // @Override
    public void Remove(Tweet tweet) {
        em.remove(tweet);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

  //  @Override
    public Tweet find(Long id) {
        System.out.println("dao.TweetDao.find()");
        return (Tweet) em.createNamedQuery("Tweet.findbyid").setParameter("id", id).getSingleResult(); 
      }
    
    
    
}
