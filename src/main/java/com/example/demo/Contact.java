package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Contact {
    private int matricule;
    private String prenom;
    private String nom;
    private String numero;
    private String competenceFavorite;

    public Contact(int matricule, String prenom, String nom, String numero, String competenceFavorite) {
        this.matricule = matricule;
        this.prenom = prenom;
        this.nom = nom;
        this.numero = numero;
        this.competenceFavorite = competenceFavorite;
    }

    public int getMatricule() {
        return matricule;
    }
    public void setMatricule() {
        this.matricule = matricule;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String nom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String competenceFavorite) {
        this.numero = numero;
    }

    public String getCompetenceFavorite() {
        return competenceFavorite;
    }
    public void setCompetenceFavorite(String competenceFavorite) {
        this.competenceFavorite = competenceFavorite;
    }

    public void inscriptionContact(){
        String sql = "INSERT INTO apprenant (matricule, prenom, nom, numero, competence) VALUES (?,?,?,?,?)";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, matricule);
            pstmt.setString(2, prenom);
            pstmt.setString(3, nom);
            pstmt.setString(4, numero);
            pstmt.setString(5, competenceFavorite);

            pstmt.executeUpdate();
            System.out.println("Contact ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du contact : " + e.getMessage());
        }
    }
}
