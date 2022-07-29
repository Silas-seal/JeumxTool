/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeumx.rs.services;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.util.*;

/**
 *
 * @author Silas
 */

@ApplicationPath("rest")
public class ServiceBase extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        
        Set<Class<?>> classes=new HashSet();
        
        addClasses(classes);
        
        return classes;
        
    }
    
    private void addClasses(Set<Class<?>> set) {
        
        set.add(com.jeumx.rs.services.sendMessage.class);
        set.add(com.jeumx.rs.services.download.class);
        set.add(com.jeumx.rs.services.report.class);
        
    }
    
}
