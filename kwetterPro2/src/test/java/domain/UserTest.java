/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Jean Paul
 */
public class UserTest {
      @Test
    public void UserTest(){
        User user1 = new User("jp", "jp");
        Role role = new Role("testRole");
        List<User> listUser = new ArrayList<>();
        listUser.add(user1);
        role.setUser_role(listUser);
        
        Assert.assertTrue(1 == role.getUser_role().size());
    }
}
