/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

import domain.Tweet;
import domain.HelloUser;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import service.TweetService;

/**
 *
 * @author 878550
 */
@Stateless
@Path("tweet")
public class TweetResource {
    @Inject
    TweetService cs;
    
    @Context
    UriInfo uriInfo;

    
    @GET
    @Path("all")
    public List<Tweet> allTweets(){
        List<Tweet> tweets = new ArrayList<>();
        tweets = cs.allTweets();
        return tweets;
    }
    
    @GET
    @Path("{id}")
    public Tweet getTweet(@PathParam("id") Long id) {
        Tweet tweet = cs.getTweet(id);
        return tweet;
        
    }
    
    @POST
    public Response addTweet(Tweet tweet) {
        cs.createTweet(tweet);
        URI uri = null;
        if (tweet != null) {
            uri = uriInfo.getAbsolutePathBuilder().
                    path(tweet.getId().toString()).
                    build();
        }
        return Response.created(uri).build();
    }
    
}
