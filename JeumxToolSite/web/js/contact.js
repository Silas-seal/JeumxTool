/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var factory=new Factory();

var content="<div class='widgetb'>Contact us<p class='over'>You can contact us on the following emails or "+
        "send a direct message</p><p class='over'>silas.seal7@gmail.com</p>"+
        "<p class='over'>silas.remotestation@gmail.com</p></div><p/>"+
        
        "<div class='widgetbdup'>Send a direct message<p class='over'></p>"+
        "<form id='frm' name='contact' method='post' "+
        "onsubmit='return(valForm())'>"+
        
        "<input type='text' name='fullnames' class='input' placeholder='Full names' /><br/>"+
        "<input type='email' name='email' class='input' placeholder='Email' /><p/>"+
        "<textarea cols='8' rows='5' class='input' name='message' placeholder='Message'></textarea><br/>"+
        "<button type='submit'>Submit</button></form></div>";

factory.setContent(content);

document.writeln(factory.generatePage());