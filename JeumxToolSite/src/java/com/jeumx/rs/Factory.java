/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jeumx.rs;

import java.io.*;
import java.util.*;

/**
 *
 * @author Silas
 */
public class Factory {
    
    public Factory() {
        
    }
    
    public <T> void print(T t) {
        System.out.println(t);
    }
    
    public void createDataFiles() {
        
        if(!isDataEnabled()) {
            
            try {
                
                ObjectOutputStream ob=new ObjectOutputStream(new FileOutputStream("downloads.dat"));
                
                int count=0;
                
                ob.writeObject(count); ob.flush(); ob.close();
                
                
                ObjectOutputStream ob2=new ObjectOutputStream(new FileOutputStream("donate.dat"));
                
                int count2=0;
                
                ob2.writeObject(count2); ob2.flush(); ob2.close();
                
                
                ObjectOutputStream ob3=new ObjectOutputStream(new FileOutputStream("messages.dat"));
                
                Properties l=new Properties();
                
                ob3.writeObject(l); ob3.flush(); ob3.close();
                
            } catch (IOException e) {
                print(e.getMessage());
            }
            
        }
        
    }
    
    public boolean isDataEnabled() {
        
        boolean sil=false;
        
        File d=new File("downloads.dat");
        File m=new File("messages.dat");
        
        if(d.exists() && m.exists()) {
            sil=true;
        }
        
        return sil;
    }
    
    public void addNewMessage(String name, String email, String message) {
        
        createDataFiles();
        
        try {
            
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("messages.dat"));
            System.out.println("Test1");
            Properties l=(Properties) in.readObject(); in.close();
            
            l.put(l.size()+"-"+new Date().toString(),name+"jmx2022"+email+"jmx2022"+message);
            
            System.out.println("Test2"+l);
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("messages.dat"));
            out.writeObject(l); out.flush(); out.close();
            
            System.out.println("Test3");
        } catch (IOException | ClassNotFoundException x) {
            print(x.getMessage());
        }
        
    }
    
    public void countDownload() {
        
        createDataFiles();
        
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("downloads.dat"));
            
            int count=(int) in.readObject();
            
            count++;
            
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("downloads.dat"));
            out.writeObject(count); out.flush(); out.close();
            
        } catch (IOException | ClassNotFoundException ex) {
            print(ex.getMessage());
        }
        
    }
    
    public Object[] getObjects() {
        
        Object[] a=new Object[3];
        
        int count,donate;
        
        Properties messages;
        
        try {
            
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("downloads.dat"));
            count=(int) in.readObject(); in.close();
            
            ObjectInputStream ina=new ObjectInputStream(new FileInputStream("donate.dat"));
            donate=(int) ina.readObject(); ina.close();
            
            ObjectInputStream in2=new ObjectInputStream(new FileInputStream("messages.dat"));
            messages=(Properties)in2.readObject(); in2.close();
            
            a[0]=count;
            a[1]=messages;
            a[2]=donate;
            
        } catch (IOException | ClassNotFoundException x) {
            print(x.getMessage());
        }
        
        return a;
    }
    
    public String getReport() {
        
        Object[] data=getObjects();
        
        String report="Downloads : "+data[0]+"\n\nDonates : "+data[2]+"\n\n";
        
        Properties me=(Properties)data[1];
        
        
        Enumeration keys=me.propertyNames();
        
        int limit=0; List<String> list=new ArrayList();
        
        while(keys.hasMoreElements() && limit<119) {
            
            String a=(String)keys.nextElement();
            
            list.add(a);
            
            limit++;
            
        }
        
        Collections.sort(list);
        
        Collections.reverse(list);
        
        for(String a:list) {
            String[] bre=me.getProperty(a).split("jmx2022"); String mre="";
            
            for(String str:bre) {
                mre+=str+"\n";
            }
            
            report+=a+"\n"+mre+"\n\n";
            
        }
        
        return report;
    }
    
}
