package com.satish;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {

    public static void main(String[] args) throws LifecycleException {

        // Create an embedded Tomcat server instance.
        Tomcat tomcat = new Tomcat();

        // Initialize the default HTTP connector on port 8080.
        tomcat.getConnector();

        // Create a web application context with /greetings as its context path.
        Context greetingsContext = tomcat.addContext("/greetings", null);

        // Register HelloServlet with the Tomcat context.
        Tomcat.addServlet(greetingsContext, "helloServlet", new HelloServlet());

        // Map /hello URL to the registered HelloServlet.
        greetingsContext.addServletMappingDecoded("/hello", "helloServlet");

        // Start the embedded Tomcat server.
        tomcat.start();

        // Keep the server running and wait for incoming requests.
        tomcat.getServer().await();
    }
}