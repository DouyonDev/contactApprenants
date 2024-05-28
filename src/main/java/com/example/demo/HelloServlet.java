package com.example.demo;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "contactjjServlet", value = "/contacjjtServlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private List<Contact> contacts;

    public void init() {
        message = "jghgh";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String nom = request.getParameter("nom");
        //String competenceFavorite = request.getParameter("competenceFavorite");
       // Contact contact = new Contact(nom, competenceFavorite);
        //contact.inscriptionContact();
        //doGet(request, response);
    }

    public void destroy() {
    }
}