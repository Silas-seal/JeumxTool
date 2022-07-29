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

@Path("report")
public class report {
    
    @Context
    private UriInfo uriInfo;
    
    @Context
    private HttpHeaders httpheaders;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getReport() {
        
        com.jeumx.rs.Factory factory=new com.jeumx.rs.Factory();
        
        return factory.getReport();
        
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
