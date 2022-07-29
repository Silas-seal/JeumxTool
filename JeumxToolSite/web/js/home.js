/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var factory=new Factory();

var content="<div class='widget'>Run and deploy JavaFX<p class='over'>Jeumx tool allows Javafx developers to quickly "+
        "create desktop executables supported to run on Java 11+"+
        "</p><a target='_self' href='download.html'>Get it NOW!</a></div>"+
        
        "<h2>What is Jeumx Tool?</h2>"+
        "<p>Jeumx tool is a developer utility built targeting javafx packaging and runtime on Java 11+.<p/>"+
        "It allows engineers to create launching executables packaged to run javafx applications outside "+
        "ide, directly on the Java Virtual Machine (JVM).<p/>"+
        "All you need to do is create your javafx project using your preferred IDE, build the JAR archive "+
        "from the project and then use this tool to generate executables of your application."+
        "</p>"+
        
        "<div class='widgetb'>Your quick guide!<p class='over'>It is direct and easy to use. You can become "+
        "a Jeumx Tool expert within less than 15 minutes. Start tutorial now!</p>"+
        "<a target='_self' href='doc.html'>Read documentation</a></div><p/>"+
        
        "<div class='dev'>Developer<p class='over'>Jeumx tool was developed by Muwanguzi Silas, a "+
        "software engineer at Remote Station</p>"+
        "<p class='desc'>'I love using Java + JavaFX in development of rich client applications. Am happy "+
        "to present to you this tool which am also using in running and packaging software'</p>"+
        "<p class='over'>Hire Silas : silas.seal7@gmail.com</p></div><p/>"+
        
        "<div class='widgetbdup'>Donate<p class='over'>We target to extend this tool project to also make builds for "+
        "Mac OS, Linux and Mobile platforms. Your support through donation can accelerate this process "+
        "and help us deliver better versions.</p><a target='_self' href='donate.html'>Donate (Paypal)</a></div><p/>"+
        
        "<div class='widgetd'>Download it now!<p class='over'>Remember, it is FREE! Get it right away.</p>"+
        "<a target='_self' href='download.html'>Download</a></div>";

factory.setContent(content);

document.writeln(factory.generatePage());