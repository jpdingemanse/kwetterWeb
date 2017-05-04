/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.UserService;

/**
 *
 * @author 878550
 */
@Stateless
@Path("user")
public class UserResource {
    @Inject
    UserService cs;
    
    @GET
    //@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("all")
    public List<User> allUsers(){
        return cs.allUsers();
    }
    
    @GET
    //@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{id}")
    public User getUser(@PathParam("id") Long id) {
        User user = cs.UserById(id);
        if (user.getName() != ""){
            return cs.UserByName(user.getName());
        }else{
            return cs.UserByEmail(user.getEmail());
        }
        
    }
    
}
