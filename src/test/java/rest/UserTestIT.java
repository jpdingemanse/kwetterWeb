/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.HelloUser;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jean Paul
 */
public class UserTestIT {
    
    private WebTarget root;
    private Client client;
    
      @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @Before
    public void setUp() {
         client = ClientBuilder.newClient();
         root = this.client.target("http://localhost:8080/kwetterPro/api/user/all");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllUser(){
//        String mediaType = MediaType.TEXT_PLAIN;
//        Response response = this.root.request().get();
//        
//        assertThat(response.getStatus(), is(200));
//        assertEquals(response.readEntity(HelloUser.class), 0);
    }
    
}
