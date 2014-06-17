/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sikuliapi.rest;

import org.apache.catalina.LifecycleException;

import org.sikuliapi.rest.jetty.JettyEmbeddedRunner;

/**
 *
 * @author Alan
 */
public class Main {
    public static void main(final String[] args) throws LifecycleException{
        System.out.println("### STARTING SIKULI EMBEDDED WEB CONTAINER");
        System.out.println("Starting Jetty...");
        new JettyEmbeddedRunner().startServer();
    }
}
