/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RoleDao;
import domain.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jean Paul
 */
@Stateless
public class RoleService {
   
    @Inject
    RoleDao cd;

    public List<Role> allRoles() {
        return cd.FindAll();
    }

    public Role create(Role role) {
        cd.Create(role);
        return role;
    }
    
    public void setDao(RoleDao roleDao) {
        this.cd = roleDao;
    }
}
