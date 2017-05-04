/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Role;
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
public class RoleDao {

    @PersistenceContext
    EntityManager em; 
    
    
    public RoleDao(){
        
    }
    
    public RoleDao(EntityManager em){
        this.em = em;
    }
    
    
    public Role Create(Role role) {
        try{
           em.persist(role);
           em.flush();
           return em.find(Role.class, role.getGroupName());
        }catch (Exception e) {
            return null;
        }
    }

    
    public void Edit(Role role) {
        em.merge(role);
    }

    
    public List<Role> FindAll() {
        return em.createNamedQuery("Role.all").getResultList();
    }

    
    public void Remove(Role role) {
        em.remove(role);
    }
    
    public Boolean addRoleToUser(Role role) {
         try {
           em.merge(role);
           return true;
       }
       catch (Exception e) {
           return false;
       }
    }

//    public EntityManager getEm() {
//        return em;
//    }
//
//    public void setEm(EntityManager em) {
//        this.em = em;
//    }

   
    
    
    
}
