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

@Path("download/{dtype}")
public class download {
    
    @Context
    private UriInfo uriInfo;
    
    @Context
    private HttpHeaders httpheaders;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String download(@PathParam("dtype") String dtype) {
        
        String dlink="";
        
        com.jeumx.rs.Factory factory=new com.jeumx.rs.Factory();
        factory.countDownload();
        
        if(dtype.equals("jeumx")) {
            dlink="downloads/JeumxTool_1.0.1.zip";
        } else if(dtype.equals("sdk")) {
            dlink="downloads/JeumxTool-sdk.zip";
        }
        
        return dlink;
        
    }
    
    @PUT
    public void doPut() {
        
    }
    
}
