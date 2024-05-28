package com.example.demo;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "deleteContactServlet", value = "/deleteContactServlet")
public class DeleteContactServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int matricule = Integer.parseInt(request.getParameter("matricule"));

        // Trouver et supprimer le contact correspondant au matricule
        contactServlet.contacts.removeIf(contact -> contact.getMatricule() == matricule);

        // Rediriger vers la page de contacts mise à jour
        response.sendRedirect("contactServlet");
    }
}
