/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function valDon() {
    
    if(document.donate.amount.value==="") {
        alert("Kindly enter amount to donate!");
        document.donate.amount.focus();
        return false;
    }
    
    if(document.donate.amount.value<=0) {
        alert("Kindly enter valid amount to proceed!");
        document.donate.amount.focus();
        return false;
    }
    
    return (true);
}

var factory=new Factory();

var content="<div class='don'>Donate to support project<p class='over'>Your donation enables us better the "+
        "future versions of this tool. We target to extend Jeumx Tool to also build executables and packages for Mac OS, Linux and Mobile platforms. "+
        "Your support fuels the engine to archive this purpose.</p>"+
        "<p class='over'><h4>Paypal donation</h4><form name='donate' action='AuthorizePaymentServlet' method='post' onsubmit='return(valDon())'>"+
        "<input type='number' step='0.01' name='amount' placeholder='($) amount' class='ginput' />"+
        
        "<input type='hidden' name='product' value='Donation to Jeumx Tool Project' />"+
                                "<input type='hidden' name='shipping' value='0' />"+
                                "<input type='hidden' name='tax' value='0' />"+
                                
                                "<input type='hidden' name='cancel' value='https://jeumxtool.herokuapp.com/donate.html' />"+
                                "<input type='hidden' name='return' value='https://jeumxtool.herokuapp.com/ReviewPaymentServlet' />"+
        
        "<button type='submit'>Donate</button><thanks>Thank you!</thanks></p>";

factory.setContent(content);

document.writeln(factory.generatePage());