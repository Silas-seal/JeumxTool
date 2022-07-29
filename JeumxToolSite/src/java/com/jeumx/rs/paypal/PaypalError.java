/*
 * initial login page
 */

package com.jeumx.rs.paypal;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Seumx Plus
 */

@WebServlet(name = "PaypalError", urlPatterns = {"/PaypalError"})
public class PaypalError extends HttpServlet {
   
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
        
        String content="<center>"
                + "<div style='background:lightgrey; position:fixed; width:100%; height:100%'>"
                + "<div style='background:slategrey; color:white;'>"
                + "<h1>The following Paypal error has occured!</h1>"
                + "<p>"+request.getAttribute("errorMessage")+"</p>"
                + "<h2><a target='_self' href='donate.html' style='color:white;'>Return</a></h2></div></div></center>";
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println(content);
            
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