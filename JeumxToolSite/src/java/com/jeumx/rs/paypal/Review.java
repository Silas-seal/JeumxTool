/*
 * initial login page
 */

package com.jeumx.rs.paypal;

import java.io.*;
import javax.servlet.http.*;

import com.paypal.api.payments.*;
import javax.servlet.annotation.WebServlet;
//import static com.paypal.base.Constants.*;
//import com.paypal.base.rest.APIContext;
//import com.paypal.base.rest.PayPalRESTException;


/**
 *
 * @author Seumx Plus
 */

@WebServlet(name = "Review", urlPatterns = {"/Review"})
public class Review extends HttpServlet {
   
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
                    
                    
                            //Here is my body
                            String cont="<center>"
                                    + "<div style=\"background: blue; width:100%; height:100%; position:fixed;\">"
                                    + "<div style='background: skyblue; max-width: 840px; font-family: Bahnschrift; font-size:20px;'>"
                                    + "<h2>Review</h2><hr/>"
                                    + "<form action=\"Execute\" method=\"post\">"
                                    + "<input type=\"hidden\" name=\"paymentId\" value=\""+request.getParameter("paymentId")+"\" />"
                                    + "<input type=\"hidden\" name=\"PayerID\" value=\""+request.getParameter("PayerID")+"\" />"
                                    + "Description: "+trn.getDescription()+"<p/>"
                                    + "Amount: $"+trn.getAmount().getDetails().getSubtotal()+"<p/>"
                                    + "Funder's Full Names: "+pyr.getFirstName()+" "+pyr.getLastName()+"<p/>"
                                    + "Funder's Email: "+pyr.getEmail()+"<hr/>"
                                    + "<button style=\"padding: 7px; font-size: 20px;\" type=\"submit\">Donate Now!</button>"
                                    + "</form></div>"
                                    + "<p/><font color='white' size='+1'>Jeumx Tool Paypal donation</font>"
                                    + "</div></center><hr/>";
                
        try (PrintWriter out = response.getWriter()) {
            
            out.println(cont);
            
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