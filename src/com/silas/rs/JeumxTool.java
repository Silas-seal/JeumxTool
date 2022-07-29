/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.silas.rs;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.*;
import java.util.*;
import java.nio.file.*;

/**
 *
 * @author Silas
 */
public class JeumxTool extends Application {
    
    @Override
    public void start(Stage stage) {
        
        stage.setTitle("Jeumx Tool | 1.0.1");
        stage.setWidth(677);
        stage.setHeight(401);
        
        Label l=new Label("Jeumx Tool");
        l.setStyle("-fx-font:normal 27px 'Trebuchet MS'; -fx-text-fill:white;");
        
        Label state=new Label("Status");
        state.setStyle("-fx-font:normal 21px 'Trebuchet MS'; -fx-text-fill:white;");
        
        TextField appname=new TextField();
        appname.setPromptText("Application name");
        appname.setStyle("-fx-font: normal 21px 'Trebuchet MS'; -fx-text-fill: royalblue; "
                + "-fx-background-color:white; -fx-padding:9px;");
        appname.setPrefWidth(700);
        
        TextField mainclass=new TextField();
        mainclass.setPromptText("Main class");
        mainclass.setStyle("-fx-font: normal 21px 'Trebuchet MS'; -fx-text-fill: royalblue; "
                + "-fx-background-color:white; -fx-padding:9px;");
        
        TextField libdir=new TextField();
        libdir.setPromptText("App work space");
        libdir.setStyle("-fx-font: normal 21px 'Trebuchet MS'; -fx-text-fill: royalblue; "
                + "-fx-background-color:white; -fx-padding:9px;");
        
        Button submit=new Button("Generate now");
        submit.setStyle("-fx-background-color:whitesmoke; -fx-font:normal 21px 'Trebuchet MS'; "
                + "-fx-text-fill: green; -fx-padding: 8px; -fx-transition: background-color 1s;");
        
        GridPane v=new GridPane();
        v.setPadding(new Insets(18));
        v.setAlignment(Pos.CENTER);
        v.setStyle("-fx-background-color:linear-gradient(to right, dodgerblue,chocolate)");
        v.setVgap(18);
        v.setHgap(8);
        
        v.add(l,0,0);
        v.add(appname,0,1);
        v.add(mainclass,0,2);
        v.add(libdir,0,3);
        v.add(state,0,5);
        v.add(submit,0,4);
        
        stage.setScene(new Scene(v));
        
        stage.show();
        
        /*stage.setOnShown(act->{
            submit.fire();
        });*/
        
        submit.setOnMouseMoved(ev->{
            submit.setStyle("-fx-background-color: green; -fx-font:normal 21px 'Trebuchet MS'; "
                + "-fx-text-fill: whitesmoke; -fx-padding: 8px;-fx-transition: background-color 1s;");
            //submit.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.GREEN,new CornerRadii(0),new Insets(17))));
        });
        submit.setOnMouseExited(ev->{
            submit.setStyle("-fx-background-color:whitesmoke; -fx-font:normal 21px 'Trebuchet MS'; "
                + "-fx-text-fill: green; -fx-padding: 8px;-fx-transition: background-color 1s;");
        });
        
        submit.setOnAction(we->{
            
            if(isValid(appname,mainclass,libdir)) {
                
                state.setText("Working...");
                
                
                    javafx.animation.FadeTransition fd1=
                            new javafx.animation.FadeTransition(javafx.util.Duration.millis(817));
                    fd1.setNode(state);
                    fd1.setFromValue(0);
                    fd1.setToValue(1);
                    fd1.setAutoReverse(false);
                    fd1.setCycleCount(1);
                    
                    fd1.play();
                    
                    fd1.setOnFinished(as->{
                        state.setText("Working.......");
                    
                    
                
                //write files
                copy(appname.getText(), libdir.getText());
                copyCli(appname.getText(), libdir.getText());
                copyZip(appname.getText(), libdir.getText());
                
                //write RunScript
                ScriptTemp t=new ScriptTemp();
                
                //bat script
                String script=t.getScript(mainclass.getText(), libdir.getText());
                
                File sr=new File(libdir.getText()+"/bin/RunScript.bat");
                
                //vbs script
                String vbs=t.getRunnerScript();
                
                File srvbs=new File(libdir.getText()+"/bin/runner.bat.vbs");
                
                
                try {
                    
                    FileWriter writer=new FileWriter(sr);
                    
                    writer.write(script);
                    writer.flush();
                    writer.close();
                    
                    FileWriter writer2=new FileWriter(srvbs);
                    
                    writer2.write(vbs);
                    writer2.flush();
                    writer2.close();
                    
                    createDist(appname.getText(), libdir.getText());
                    
                    javafx.animation.FadeTransition fd=
                            new javafx.animation.FadeTransition(javafx.util.Duration.millis(817));
                    fd.setNode(state);
                    fd.setFromValue(0);
                    fd.setToValue(1);
                    fd.setAutoReverse(false);
                    fd.setCycleCount(1);
                    
                    fd.play();
                    
                    fd.setOnFinished(a->{
                        state.setText("Operation successfully finished!");
                    });
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
                });
                
            } else {
                state.setText("Enter valid data!");
            }
            
        });
        
    }
    
    private boolean isValid(TextField tf1,TextField tf2,TextField tf3) {
        
        boolean valid=true;
        
        if(tf1.getText().length()<1) {
            valid=false;
        }
        if(tf2.getText().length()<1) {
            valid=false;
        }
        if(tf3.getText().length()<1) {
            valid=false;
        }
        
        return valid;
        
    }
    
    private void copy(String app, String libd) {
        
        try {
             File d=new File(libd+"/bin");
            if(!d.exists()) {
                d.mkdir();
            }
            
            InputStream in=getClass().getResourceAsStream("AppLauncher.exe");
            
            OutputStream out=new FileOutputStream(libd+"/bin/"+app+".exe");
            
            int i;
            while((i=in.read())>-1) {
                out.write(i);
            }
            
            out.flush(); out.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    private void copyCli(String app, String libd) {
        
        try {
             File d=new File(libd+"/bin");
            if(!d.exists()) {
                d.mkdir();
            }
            
            InputStream in=getClass().getResourceAsStream("AppLauncher_cli.exe");
            
            OutputStream out=new FileOutputStream(libd+"/bin/"+app+"_cli.exe");
            
            int i;
            while((i=in.read())>-1) {
                out.write(i);
            }
            
            out.flush(); out.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    private void copyZip(String app, String libd) {
        
        try {
             File d=new File(libd+"/dist");
            if(!d.exists()) {
                d.mkdir();
            }
            
            InputStream in=getClass().getResourceAsStream("AppZip.zip");
            
            OutputStream out=new FileOutputStream(libd+"/dist/"+app+".zip");
            
            int i;
            while((i=in.read())>-1) {
                out.write(i);
            }
            
            out.flush(); out.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    private void createDist(String app, String libd) {
        
        File f=new File(libd+"/dist");
        if(!f.exists()) {
            f.mkdir();
        }
        
        Map<String,String> env=new HashMap<>();
        env.put("create","true");
        env.put("encoding","UTF-8");
        
        java.net.URI uri=java.net.URI.create("jar:file:/"+
                f.getAbsolutePath().replace("\\","/")+"/"+app+".zip");
        
        try (FileSystem zip=FileSystems.newFileSystem(uri,env)) {
            
            //EXE
            Path ap=zip.getPath("/bin/"+app+".exe");
            Path ex=Paths.get(new File(libd+"/bin/"+app+".exe").toURI());
            Files.write(ap, Files.readAllBytes(ex));
            
            //EXE_CLI
            Path ap2=zip.getPath("/bin/"+app+"_cli.exe");
            Path ex2=Paths.get(new File(libd+"/bin/"+app+"_cli.exe").toURI());
            Files.write(ap2, Files.readAllBytes(ex2));
            
            //RunScript
            Path ap3=zip.getPath("/bin/RunScript.bat");
            Path ex3=Paths.get(new File(libd+"/bin/RunScript.bat").toURI());
            Files.write(ap3, Files.readAllBytes(ex3));
            
            //Runner
            Path ap4=zip.getPath("/bin/runner.bat.vbs");
            Path ex4=Paths.get(new File(libd+"/bin/runner.bat.vbs").toURI());
            Files.write(ap4, Files.readAllBytes(ex4));
            
            //Copy all libraries [jar]
            File lib=new File(libd+"/lib");
            
            File[] libs=lib.listFiles();
            
            for(File li:libs) {
                
                if(li.list()==null) {
                    
                    Path ap5=zip.getPath("/lib/"+li.getName());
                    Path ex5=Paths.get(li.toURI());
                    Files.write(ap5, Files.readAllBytes(ex5));
                    
                }
                
            }
            
            //Copy all sdk [jar]
            File lib2=new File(libd+"/lib/javafx");
            
            File[] libs2=lib2.listFiles();
            
            for(File li:libs2) {
                
                if(li.list()==null) {
                    
                    Path ap5=zip.getPath("/lib/javafx/"+li.getName());
                    Path ex5=Paths.get(li.toURI());
                    Files.write(ap5, Files.readAllBytes(ex5));
                    
                }
                
            }
            
            System.out.println("Application packaged!");
            
        } catch (IOException i) {
            i.printStackTrace();
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}

/*

This application will make launchers for a standard javafx application which runs when JAVAFX_HOME is 
set;

But for gluon applications, you only need to add javafx.fxml to lib+all required jars unrepeated
and replacing JAVAFX_HOME with 
APP_HOME in the RunScript file. The app runs independently without the JFX runtimes.

*/