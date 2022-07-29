/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function downloadjeumx() {
    
    jQuery.ajax({
        type:'get',
        url: 'rest/download/jeumx'
    })
            .done(function(data){
                document.location=data;
    })
            .fail(function(){
                alert("Communication error!");
    })
            .always(function(){
                console.log("Ajax executed!");
    });
    
}

function downloadjeumxsdk() {
    
    jQuery.ajax({
        type:'get',
        url: 'rest/download/sdk'
    })
            .done(function(data){
                document.location=data;
    })
            .fail(function(){
                alert("Communication error!");
    })
            .always(function(){
                console.log("Ajax executed!");
    });
    
}

var factory=new Factory();

var content="<div class='widgetc'>Download Jeumx Tool<p class='over'>Download today and start running and "+
        "packaging JavaFX applications smartly</p>"+
        "<p class='over'>App name : Jeumx Tool</p>"+
        "<p class='over'>Version : 1.0.1</p>"+
        "<p class='over'>Technology : Java 11+</p>"+
        "<p class='over'>Platform : Microsoft Windows</p>"+
        "<p class='over'>Download size : 9MB</p>"+
        "<p class='over'>Release date : 11th May, 2022</p>"+
        "<p class='over'>Developer : Muwanguzi Silas @Remote Station</p>"+
        "<a target='_self' href='javascript:downloadjeumx()'>Download NOW</a></div><p/>"+
        
        "<div class='widgetb'>JeumxTool-sdk<p class='over'>This is basically an archive containing JavaFX "+
        "development libraries combined for desktop execution. These are included in Jeumx Tool archive "+
        "and you can find them in 'lib/javafx'</p>"+
        "<a target='_self' href='javascript:downloadjeumxsdk()'>Download sdk</a></div><p/>"+
        
        "<div class='widgetbdup'>Reference<p class='over'>Kindly refer to the documentation on how "+
        "to use this tool. You can also get support by contacting us.</p>"+
        "<a target='_self' href='doc.html'>Read documentation</a></div>";

factory.setContent(content);

document.writeln(factory.generatePage());