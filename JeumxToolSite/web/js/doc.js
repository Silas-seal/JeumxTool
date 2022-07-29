/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var factory=new Factory();

var content="<div class='widgetd'>Jeumx Tool documentation<p class='over'>This is your reference document while utilizing "+
        "this tool. Please contact us for additional support where needed.</p></div>"+
        
        "<h2>Overview</h2>"+
        "Jeumx Tool is a Java packaging and runtime tool. We assume that you have Java (jdk) version 11 or above installed. "+
        "You can download and install java from <a target='_blank' href='https://www.oracle.com/technetwork/java/javase/downloads'>here</a><p/>"+
        "You may need to set JAVA_HOME in environment variables if you did not install java with a '.exe' setup. This step "+
        "can be skipped if java is installed as a program. The application will directly find Java installed.<p/>"+
        "We also expect that you atleast have an entry level experience in building Java + Javafx applications.<p/>"+
        
        "<h2>Installation</h2>"+
        "<ul type='square'>"+
        "<li>Download the 'JeumxTool.zip' archive from the download page</li><p/>"+
        "<li>Extract the archive to a directory for example 'E:\\JeumxTool_1.0.1'</li><p/>"+
        "<li>Browse to 'bin' directory and run 'JeumxTool.exe' to view the tool</li><p/>"+
        "<img src='images/jeumxtool.png' class='window' alt='Jeumx' /><p/>"+
        "<li>If the above window does not appear, please run the 'RunScript.bat' from command by typing 'RunScript' "+
        "to trace and resolve startup problems</li></ul>"+
        
        "<h2>Building executables</h2>"+
        "<ul type='square'>"+
        "<li>Build a javafx project using your preferred IDE and get the executable Jar file</li><p/>"+
        "<li>Create a workspace directory for example 'E:\\MyJavafxapp'</li><p/>"+
        "<li>Create a directory named 'lib' in the created workspace directory</li><p/>"+
        "<li>Copy and paste your application Jar file into the created 'lib' directory</li><p/>"+
        "<li>Add project third party java libraries (jars) into the 'lib' directory too if the project uses any</li><p/>"+
        "<li>Copy the 'javafx' directory found in Jeumx Tool 'lib' folder for example 'E:\\JeumxTool_1.0.1\\lib' and paste it into your workspace"+
        " 'lib' folder for example 'E:\\MyJavafxapp\\lib'. Be sure now that your workspace directory tree matches the example tree below.</li><p/>"+
        "<img src='images/tree.png' alt='tree' /><p/>"+
        "<li>Now let us go to Jeumx Tool and fill the fields. The first field is where you write your application name, "+
        "the second field your application main class (an executable class), the third and last field your workspace ("+
        "which we have created and configured). See the example below</li><p/>"+
        "<img src='images/jeumxfill.png' class='window' alt='JeumxTool fill' /><p/>"+
        "<li>Now you can as well click 'Generate now' to create your app executables.</li><p/>"+
        "<li>After generating, your workspace tree should match the example tree below</li><p/>"+
        "<img src='images/tree2.png' alt='tree' /><p/>"+
        "<li>Application executables are found in the 'bin' directory of your app workspace "+
        "and the zip packaged application in 'dist'.</li><p/></ul>"+
        
        "<h2>Running executables</h2>"+
        "From our example above, you can run the application executables in 'bin' directory as follows<p/>"+
        "<ul type='square'>"+
        "<li>Run 'MyJavafxapp.exe' to launch applicaton without the logging console</li><p/>"+
        "<li>Run 'MyJavafxapp_cli.exe' to launch application with a logging consoles (commandline interface)</li><p/>"+
        "</ul>"+
        
        "<h2>Debugging application</h2>"+
        "You can debug the application and trace failures by running the 'RunScript.bat' file found in the 'bin' folder "+
        "of your workspace. Type 'RunScript' in your cmd and view the startup status of your application.<p/>"+
        
        "<h2>Updating application</h2>"+
        "You do not need to repeat the above build process when you update/rebuild your javafx application, "+
        "you only need to copy the new built app Jar file into the 'lib' directory of app workspace to replace the "+
        "existing old Jar. By that you have updated the app.<p/>"+
        "However, if you have added new jar libraries/dependencies to your project, you'll need to copy the "+
        "new Jar and added jar libraries into the 'lib' directory of app workspace. Then launch Jeumx Tool "+
        "and fill the field as explained in the above chapter 'Building executables' to make a new build (update) "+
        "of your application."+
        
        "<h2>Supporting web and media modules</h2>"+
        "If your application uses the javafx.web or javafx.media modules, you'll need to add support for your Jdk to display "+
        "web documents and play media files.<p/>"+
        "<ul type='square'>"+
        "<li>Download javafx sdk from <a target='_blank' href='https://download2.gluonhq.com/openjfx/17.0.2/openjfx-17.0.2_windows-x64_bin-sdk.zip'>"+
        "here</a></li><p/>"+
        "<li>Extract the sdk to your preferred directory</li><p/>"+
        "<li>Notice the following 12 files in the 'bin' directory of the javafx sdk and copy them into the 'bin' directory "+
        "of your Jdk</li><p/><div style='background: black; color:lightgrey;padding:18px;'>"+
        "decora_sse.dll<br/>fxplugins.dll<br/>glass.dll<br/>glib-lite.dll<br/>gstreamer-lite.dll<br/>javafx_font.dll<br/>"+
        "javafx_iio.dll<br/>jfxmedia.dll<br/>jfxwebkit.dll<br/>prism_common.dll<br/>prism_d3d.dll<br/>prism_sw.dll</div><p/>"+
        "<li>Now your Jdk is well supported to view web pages and play media files</li></u><p/>"+
        
        "<h2>Conclusion</h2>"+
        "Javafx is a powerful, light weight, hardware accelerated technology for building rich GUI applications. <p/>"+
        "Thank you for taking time to read this tutorial, you are now well equiped with knowledege to use this tool. "+
        "If you need assistance concerning this tool or relating to Java - Javafx, please contact me <a href='contact.html'>"+
        "here</a><p/>Regards<p/>Muwanguzi Silas<p/>Software engineer @Remote Station<p/>Hire me : silas.seal7@gmail.com<hr/>";

factory.setContent(content);

document.writeln(factory.generatePage());