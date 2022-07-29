/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeumx.rs.services;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Silas
 */
@Path("sendmessage")
public class sendMessage {
    
    @Context
    private UriInfo uriInfo;
    
    @Context
    private HttpHeaders httpheaders;
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String doSend(@FormParam("fullnames") String name, @FormParam("email") String email,
            @FormParam("message") String message) {
        
        com.jeumx.rs.Factory factory=new com.jeumx.rs.Factory();
        factory.addNewMessage(name, email, message);
        
        return "Your message has been received! We'll be in touch soon. Thank you!";
    }
    
    @GET
    public String hello() {
        return "Hello world!";
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
