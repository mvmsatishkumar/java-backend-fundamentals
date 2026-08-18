package com.satish;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    // Called once when the servlet is created and initialized.
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet initialized");
    }

    // Handles HTTP GET requests.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Get the HTTP method used for the request.
        String method = req.getMethod();

        // Get the complete request URI.
        String uri = req.getRequestURI();

        // Get a query parameter such as /hello?name=Satish.
        String name = req.getParameter("name");

        // Get a request header sent by the client.
        String userAgent = req.getHeader("User-Agent");

        // Set the response content type and character encoding.
        resp.setContentType("text/plain");

        // Set the HTTP response status code.
        resp.setStatus(HttpServletResponse.SC_OK);

        // Write the response body back to the client.
        resp.getWriter().println("Hello " + (name != null ? name : "World"));

        // Print request information to the server console.
        System.out.println("Method: " + method);
        System.out.println("URI: " + uri);
        System.out.println("User-Agent: " + userAgent);
    }

    // Handles HTTP POST requests.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Read a form parameter sent in the POST request.
        String name = req.getParameter("name");

        // Set the response content type.
        resp.setContentType("text/plain");

        // Send a successful HTTP response.
        resp.setStatus(HttpServletResponse.SC_OK);

        // Send the response back to the client.
        resp.getWriter().println("POST received for: " + name);
    }

    // Handles HTTP PUT requests.
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Read the request body sent by the client.
        BufferedReader reader = req.getReader();

        // Store the request body in a StringBuilder.
        StringBuilder body = new StringBuilder();

        // Read the request body line by line.
        String line;

        while ((line = reader.readLine()) != null) {
            body.append(line);
        }

        // Set the response content type.
        resp.setContentType("text/plain");

        // Send a successful HTTP response.
        resp.setStatus(HttpServletResponse.SC_OK);

        // Return the received request body to the client.
        resp.getWriter().println("PUT received: " + body);
    }

    // Handles HTTP DELETE requests.
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Get an ID from a query parameter such as /hello?id=10.
        String id = req.getParameter("id");

        // Set the response content type.
        resp.setContentType("text/plain");

        // Send a successful HTTP response.
        resp.setStatus(HttpServletResponse.SC_OK);

        // Return a message indicating the resource to delete.
        resp.getWriter().println("DELETE received for id: " + id);
    }

    // Called once when the servlet is being removed or the server stops.
    @Override
    public void destroy() {
        System.out.println("Servlet destroyed");
    }
}