package com.example.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "contactServlet", value = "/contactServlet")
public class contactServlet extends HttpServlet {
    public static List<Contact> contacts = new ArrayList<>();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("/contacts.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int matricule = generateMatricule();
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String numero = request.getParameter("numero");
        String competenceFavorite = request.getParameter("competenceFavorite");
        Contact contact = new Contact(matricule,prenom,nom,numero,competenceFavorite);
        contacts.add(contact);
        contact.inscriptionContact();
        doGet(request, response);

    }

    private int generateMatricule() {
        if (contacts.isEmpty()) {
            return 1; // Commencer les matricules à 1 si la liste est vide
        } else {
            // Obtenir le dernier matricule et incrémenter de 1
            return contacts.get(contacts.size() - 1).getMatricule() + 1;
        }
    }
    public void destroy() {
    }
}