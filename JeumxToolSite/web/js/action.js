/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function valForm() {
    
    if(document.contact.fullnames.value==="") {
        alert("Please provide your names!");
        document.contact.fullnames.focus();
        return false;
    }
    
    if(document.contact.email.value==="") {
        alert("Please provide your email!");
        document.contact.email.focus();
        return false;
    }
    
    if(document.contact.message.value==="") {
        alert("Please compose your message!");
        document.contact.message.focus();
        return false;
    }
    
    //Execute Ajax
    jQuery.ajax({
        type: 'post',
        url: 'rest/sendmessage',
        data: jQuery("#frm").serialize()
    })
            .done(function(data){
                document.contact.message.value="";
                document.contact.fullnames.value="";
                document.contact.email.value="";
                alert(data);
        
    })
            .fail(function(){
                alert("Communication error!");
    });
    
    return (false);
}

jQuery(document).ready(function(){
    jQuery(".load").fadeOut("slow");
});