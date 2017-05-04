/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.rest;

//package com.mkyong.json;

import com.google.gson.Gson;
import domain.Tweet;
import domain.User;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.TweetService;
import service.UserService;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author 878550
 */
@Stateless
@Path("tweet")
public class TweetResource {

    @Inject
    TweetService cs;

    @Inject
    UserService us;

    ObjectMapper mapper = new ObjectMapper();
    
    @GET
    @Path("all")
    public List<Tweet> allTweets() {
        List<Tweet> tweets = cs.allTweets();
        return tweets;
    }

    @GET
    @Path("{id}")
    public Tweet getTweet(@PathParam("id") Long id) {
        Tweet tweet = cs.getTweet(id);
        return tweet;

    }

    @GET
    @Path("createtweet/{id}/{message}")
    public String createTweet(@PathParam("message") String message, @PathParam("id") Long id) throws IOException {
       User u = us.UserById(id);

        Tweet t = new Tweet(message, new Date());

        u.addTweet(t);

        Tweet tweet = cs.createTweet(t);
        System.out.println(id + message + t.getId() + t.getMessage() + t.getTime());

        String jsonString = "{\"tweet\": { \"id\": \""+ tweet.getId() + "\", \"message\": \"" + tweet.getMessage() + "\" }" ;
        return jsonString;
    }

}
