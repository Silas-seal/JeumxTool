/*
 * initial login page
 */

package com.jeumx.rs.paypal;

import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

import com.paypal.api.payments.*;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Seumx Plus
 */
@WebServlet(name = "Receipt", urlPatterns = {"/Receipt"})
public class Receipt extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws java.lang.Exception
     * 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws Exception {

        response.setContentType("text/html;charset=UTF-8");
        
                //lets get the attributes
                    Transaction trn=(Transaction)request.getAttribute("transaction");
                    PayerInfo pyr=(PayerInfo)request.getAttribute("payer");
                
                String cont="<center>"
                        + "<div style=\"background: green; width:100%; height:100%; position:fixed;\">"
                        + "<div style='background: lightgreen; max-width: 840px; font-family: Bahnschrift; font-size:20px;'>"
                        + "<p/><font color=\"green\" size=\"+2\">Success!</font><p/>"
                                    + "Your donation of $"+trn.getAmount().getDetails().getSubtotal()+" "
                        + "to Jeumx Tool project at Remote Station using Paypal has been successfully completed. A BIG 'Thank you' for your "
                        + "support! We greatly appreciate you and we promise to present better versions of this tool and more utilities."
                        + "<hr/>"
                                    + "<h3>Transaction Details</h3>"
                                    + "Merchant: Jeumx Tool - Remote Station<p/>"
                                    + "User Names: "+pyr.getFirstName()+" "+pyr.getLastName()+"<p/>"
                                    + "Amount: $"+trn.getAmount().getDetails().getSubtotal()+"<hr/>"
                                    + "Thank You "+pyr.getLastName()+"<p/>"
                                    + "<a href=\"donate.html\"><button style=\"padding: 7px; font-size: 20px;\">Ok, You Are Welcome!</button></a>"
                        + "</div></div></center><hr/>";
                
         
        try (PrintWriter out = response.getWriter()) {
            
            out.println(cont);
            
        }
        
        //Increase donations
        try {
            
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("donate.dat"));
            int donate=(int) in.readObject(); in.close();
            
            donate++;
            
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("donate.dat"));
            out.writeObject(donate); out.flush(); out.close();
            
        } catch (IOException x) {
            System.out.println(x.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try {
        processRequest(request, response);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        try {
        processRequest(request, response);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}