/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Group;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jean Paul
 */
@Stateless
public class GroupDao {

    @PersistenceContext
    EntityManager em; 
    
    
    public GroupDao(){
        
    }
    
    public GroupDao(EntityManager em){
        this.em = em;
    }
    
    
    public Group Create(Group group) {
        try{
           em.persist(group);
           em.flush();
           return em.find(Group.class, group.getGroupName());
        }catch (Exception e) {
            return null;
        }
    }

    
    public void Edit(Group group) {
        em.merge(group);
    } 
    
    
}
