
package com.jeumx.rs.paypal;

/**
 *
 * @author Seumx Plus
 */

import java.util.*;
 
import com.paypal.api.payments.*;
import com.paypal.base.rest.*;

public class PaymentServices {
    /*RS
    private final static String CLIENT_ID="ARafPzEACHTze2eVSygsmS7kT94ggiKkpEabdIFb1JmQm-t7dt9jjGsXlHtYdh2gA3dIXbEH7eeti8rG";
    private final static String CLIENT_SECRET="EJxkKxK5HEg9SUXsSo70mQeDwCtxB32yAmCy552WlQ_9F7bUVapy-_gEWQsNn5kTDzroDaKDiRQ3DixT";
    private static String MODE="live";*/
    
    private final static String CLIENT_ID="AYTtoVt8hPIWNWqyqMqs_S7BAoeXP1p7O5pAzUeVwsVam6IPchGT3bjUqr04pa_DYpeFQp0WlGyiUDo1";
    private final static String CLIENT_SECRET="EFDTiaeY0GgwaLjtHmpKx0qhSOybCcB4WWbP20sUR80TzKLnQNNjURyY-0_WS_ourqH_bbMcuqrwPN9g";
    private static String MODE="live";
    
    //Read the values from the database;
    public PaymentServices() {
        
    }
    //Here
    
    private String fname,lname,email;
    private String cancelURL, returnURL;
 
    public String authorizePayment(OrderDetail orderDetail)        
            throws PayPalRESTException {       
 
        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);
         
        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");
 
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
 
        Payment approvedPayment = requestPayment.create(apiContext);
 
        return getApprovalLink(approvedPayment);
 
    }
    
    public void setUserDate(String fname,String lname,String email) {
        
        this.fname=fname;
        this.lname=lname;
        this.email=email;
        
    }
    
    public void setRedURLs(String cancelURL,String returnURL) {
        
        this.cancelURL=cancelURL;
        this.returnURL=returnURL;
        
    }
     
    private Payer getPayerInformation() {
        Payer payer = new Payer();
    payer.setPaymentMethod("paypal");
     
    PayerInfo payerInfo = new PayerInfo();
    payerInfo.setFirstName(fname)
             .setLastName(lname)
             .setEmail(email);
     
    payer.setPayerInfo(payerInfo);
     
    return payer;
    }
     
    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelURL);
        redirectUrls.setReturnUrl(returnURL);
     
        return redirectUrls;
    }
     
    private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
        Details details = new Details();
    details.setShipping(orderDetail.getShipping());
    details.setSubtotal(orderDetail.getSubtotal());
    details.setTax(orderDetail.getTax());
 
    Amount amount = new Amount();
    amount.setCurrency("USD");
    amount.setTotal(orderDetail.getTotal());
    amount.setDetails(details);
 
    Transaction transaction = new Transaction();
    transaction.setAmount(amount);
    transaction.setDescription(orderDetail.getProductName());
     
    ItemList itemList = new ItemList();
    List<Item> items = new ArrayList<>();
     
    Item item = new Item();
    item.setCurrency("USD");
    item.setName(orderDetail.getProductName());
    item.setPrice(orderDetail.getSubtotal());
    item.setTax(orderDetail.getTax());
    item.setQuantity("1");
     
    items.add(item);
    itemList.setItems(items);
    transaction.setItemList(itemList);
 
    List<Transaction> listTransaction = new ArrayList<>();
    listTransaction.add(transaction);  
     
    return listTransaction;
    }
     
    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
    String approvalLink = null;
     
    for (Links link : links) {
        if (link.getRel().equalsIgnoreCase("approval_url")) {
            approvalLink = link.getHref();
            break;
        }
    }      
     
    return approvalLink;
    }
    
    
    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
    APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
    return Payment.get(apiContext, paymentId);
    }
    
    public Payment executePayment(String paymentId, String payerId)
        throws PayPalRESTException {
    PaymentExecution paymentExecution = new PaymentExecution();
    paymentExecution.setPayerId(payerId);
 
    Payment payment = new Payment().setId(paymentId);
 
    APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
 
    return payment.execute(apiContext, paymentExecution);
}
}