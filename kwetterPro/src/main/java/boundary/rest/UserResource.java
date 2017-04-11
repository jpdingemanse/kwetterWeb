/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import com.sun.jndi.toolkit.url.Uri;
import domain.HelloUser;
import domain.Tweet;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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
    
    @Context
    UriInfo uriInfo;

    
    @GET
    //@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("all")
    public List<HelloUser> allUsers(){
        return cs.allUsers();
    }
    
    @GET
    //@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{id}")
    public HelloUser getUser(@PathParam("id") Long id) {
         HelloUser user = cs.UserById(id);
         return user;
//        if (user.getName() != ""){
//            return cs.UserByName(user.getName());
//        }else{
//            return cs.UserByEmail(user.getEmail());
//        }
//        
    }
    
      
    @POST
    public Response addUser(HelloUser user) {
        cs.createUser(user);
        URI uri = null;
        if (user != null) {
            uri = uriInfo.getAbsolutePathBuilder().
                    path(user.getId().toString()).
                    build();
        }
        return Response.created(uri).build();
    }    
}
