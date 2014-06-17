/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sikuliapi.rest.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import org.sikuliapi.rest.servlets.find;
import org.sikuliapi.rest.servlets.click;
import org.sikuliapi.rest.servlets.wait;
import org.sikuliapi.rest.servlets.waitvanish;
import org.sikuliapi.rest.servlets.exists;
import org.sikuliapi.rest.servlets.doubleclick;
import org.sikuliapi.rest.servlets.type;
import org.sikuliapi.rest.servlets.dragdrop;

/**
 *
 * @author Alan
 */
public class JettyEmbeddedRunner {
    
    public static final String ServerPath = "/sikuli/api";
    public static final int ServerPort = 8080;
    public static final String ServerHost = "localhost";
    
    public void startServer(){
        try{
            Server server = new Server();
            ServerConnector connector = new ServerConnector(server);
            connector.setIdleTimeout(1000);
            connector.setAcceptQueueSize(10);
            connector.setPort(ServerPort);
            connector.setHost(ServerHost);
            
            //Set the server path for accessing it on the URL
            ServletContextHandler handler = new ServletContextHandler(server, ServerPath, true, false);
            
            //Set the paths for each of the different REST services
            
            //the find service
            handler.addServlet(new ServletHolder(find.class), find.ServletPath);
            
            //the click service
            handler.addServlet(new ServletHolder(click.class), click.ServletPath);
            
            //the wait service
            handler.addServlet(new ServletHolder(wait.class), wait.ServletPath);
            
            //the waitvanish service
            handler.addServlet(new ServletHolder(waitvanish.class), waitvanish.ServletPath);
            
            //the exists service
            handler.addServlet(new ServletHolder(exists.class), exists.ServletPath);
            
            //the doubleclick service
            handler.addServlet(new ServletHolder(doubleclick.class), doubleclick.ServletPath);
            
            //the type service
            handler.addServlet(new ServletHolder(type.class), type.ServletPath);
            
            //the dragdrop service
            handler.addServlet(new ServletHolder(dragdrop.class), dragdrop.ServletPath);
            
            server.addConnector(connector);
            server.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
