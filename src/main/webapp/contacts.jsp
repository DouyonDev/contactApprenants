<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Gestion des Contacts</title>
  <link rel="stylesheet" href="css/contacts.css">
</head>
<body>
<div class="container">

  <h2>Ajouter un contact</h2>
  <form method="post" action="contactServlet">
    <label for="prenom">Prenom :</label>
    <input type="text" id="prenom" name="prenom" required>
    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" required>
    <label for="numero">Numero telephone :</label>
    <input type="text" id="numero" name="numero" required>
    <label for="competenceFavorite">Compétence Favorie :</label>
    <input type="text" id="competenceFavorite" name="competenceFavorite" required>
    <input type="submit" value="Ajouter">
  </form>

  <h1>Liste des contacts</h1>
  <table>
    <thead>
    <tr>
      <th>Matricule</th>
      <th>Prenom</th>
      <th>Nom</th>
      <th>Numero</th>
      <th>Compétence Favorie</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="contact" items="${contacts}">
      <tr>
        <td>${contact.matricule}</td>
        <td>${contact.prenom}</td>
        <td>${contact.nom}</td>
        <td>${contact.numero}</td>
        <td>${contact.competenceFavorite}</td>
        <td>
          <form method="post" action="deleteContactServlet">
            <input type="hidden" name="matricule" value="${contact.matricule}">
            <input type="submit" value="Supprimer">
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
