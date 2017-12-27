<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet" href="styleheader.css" />
<title>Insertion Client</title>
</head>

<body>
	<ul>
		  <li><a href="accueilConseiller.jsp">Accueil</a></li>
		  <li><a href="ajouterClient.jsp">Ajouter un Client</a></li>
		  <li><a href="ajouterCompte.jsp">Ajouter un Compte</a></li>
		  <li style="float: right"><a class="active" href="ServletLogin">Déconnexion</a></li>
	</ul>

<h2>Formulaire d'inscription d'un client</h2>
<form action="ServletAjouterClient" method="post">
  <p><i>Complétez le formulaire. Les champs marqué par </i><em>*</em> sont <em>obligatoires</em></p>
  <fieldset>
    <legend>Contact</legend>
      <label for="nom">Nom <em>*</em></label>
      <input type="text" id="nom" name="nom" required><br>
      
      <label for="prenom">Prenom <em>*</em></label>
      <input type="text" id="prenom" name="prenom" required><br>
      
      <label for="adresse">Adresse <em>*</em></label>
      <input type="text" id="adresse" name="adresse" required><br>
      
      <label for="codePostal">Code Postal <em>*</em></label>
      <input type="text" id="codePostal" name="codePostal" required><br>
      
      <label for="ville">Ville <em>*</em></label>
      <input type="text" id="ville" name="ville" required><br>
      
      <label for="telephone">Telephone</label>           
      <input id="telephone" type="tel" placeholder="06xxxxxxxx" name="telephone"><br>
      
      <label for="email">Email <em>*</em></label>
      <input id="email" name="email" type="email" placeholder="prenom.nom@gmail.com" required><br>
  </fieldset>
  <fieldset>
    <legend>Information administrative</legend>    
      <label for="typeClient">typeClient<em>*</em></label>
      <select id="typeClient">
        <option value="particulier" name="typeClient">Particulier</option>
        <option value="Entreprise" name="typeClient">Entreprise</option>
      </select><br>
      
      <label for="idConseiller">Id Conseiller</label>
		<input type="text" id="idConseiller" name="idConseiller" value="${NumConseiller}"><br>
  </fieldset> 
 
  <p><input type="submit" value="Soummettre"></p>
</form>
</body>

</html>