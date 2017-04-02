package service;

import dao.FollowerDao;
import dao.RoleDao;
import domain.Follower;
import domain.HelloUser;
import domain.Role;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jean Paul
 */
@Stateless
public class FollowerService {
    
    @Inject
    FollowerDao cd;

    public List<Follower> allFollowers(HelloUser user) {
        return cd.FindAll(user);
    }

    public Follower create(Follower followers) {
        cd.Create(followers);
        return followers;
    }
    
    public void setDao(FollowerDao followersDao) {
        this.cd = followersDao;
    }
}
