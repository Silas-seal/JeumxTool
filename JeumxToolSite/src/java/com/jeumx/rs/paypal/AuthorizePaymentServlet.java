
package com.jeumx.rs.paypal;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.paypal.base.rest.PayPalRESTException;

/**
 *
 * @author Seumx Plus
 */
@WebServlet(name = "AuthorizePaymentServlet", urlPatterns = {"/AuthorizePaymentServlet"})
public class AuthorizePaymentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String product = request.getParameter("product");
        String subtotal = request.getParameter("amount");
        String shipping = request.getParameter("shipping");
        String tax = request.getParameter("tax");
        String total = request.getParameter("amount");
        
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        
        String cancelURL = request.getParameter("cancel");
        String returnURL = request.getParameter("return");
         
        OrderDetail orderDetail = new OrderDetail(product, subtotal, shipping, tax, total);
 
        try {
            PaymentServices paymentServices = new PaymentServices();
            
            paymentServices.setUserDate(fname, lname, email); 
            paymentServices.setRedURLs(cancelURL, returnURL);
            
            String approvalLink = paymentServices.authorizePayment(orderDetail);
 
            response.sendRedirect(approvalLink);
             
        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            System.out.println(ex.getMessage());
            request.getRequestDispatcher("PaypalError").forward(request, response);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "AuthorizePaymentServlet";
    }

}