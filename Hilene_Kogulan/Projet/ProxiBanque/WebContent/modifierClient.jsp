<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet" href="styleheader.css" />
<title>Insertion Compte Client</title>
</head>
<body>
	<ul>
		  <li><a href="accueilConseiller.jsp">Accueil</a></li>
		  <li><a href="ajouterClient.jsp">Ajouter un Client</a></li>
		  <li><a href="ajouterCompte.jsp">Ajouter un Compte</a></li>
		  <li style="float: right"><a class="active" href="ServletLogin">Déconnexion</a></li>
	</ul>
	
<h2>Mise a jour information Client</h2>
<form action="" method="post">
  <p><i>Modifier le formulaire. Les champs marqué par </i><em>*</em> sont <em>obligatoires</em></p>
    <fieldset>    
    <legend>Information Client</legend>  
    <label for="idClient">Id Client</label>  
    <input type="text" id="idClient" name="idClient" value="${InfoClient.idClient}" readonly><br>
  </fieldset> 
  <fieldset>
    <legend>Contact</legend>
      <label for="nom">Nom <em>*</em></label>
      <input type="text" id="nom" name="nom" value="${InfoClient.nomClient}" ><br>
      
      <label for="prenom">Prenom <em>*</em></label>
      <input type="text" id="prenom" name="prenom" value="${InfoClient.prenomClient}" required><br>
      
      <label for="adresse">Adresse <em>*</em></label>
      <input type="text" id="adresse" name="adresse" value="${InfoClient.adresseClient}" required><br>
      
      <label for="codePostal">Code Postal <em>*</em></label>
      <input type="text" id="codePostal" name="codePostal" value="${InfoClient.codePostalClient}" required><br>
      
      <label for="ville">Ville <em>*</em></label>
      <input type="text" id="ville" name="ville" value="${InfoClient.villeClient}" required><br>
      
      <label for="telephone">Telephone</label>           
      <input id="telephone" type="tel" placeholder="06xxxxxxxx" name="telephone" value="${InfoClient.telClient}"><br>
      
      <label for="email">Email <em>*</em></label>
      <input id="email" name="email" type="email" placeholder="prenom.nom@gmail.com" value="${InfoClient.emailClient}" required><br>
  </fieldset>
  <fieldset>
    <legend>Information administrative</legend>    
      <label for="typeClient">typeClient<em>*</em></label>
      <select id="typeClient">
        <option value="particulier" name="typeClient">Particulier</option>
        <option value="Entreprise" name="typeClient">Entreprise</option>
      </select><br>
      
      <label for="idConseiller">Id Conseiller</label>
		<input type="text" id="idConseiller" name="idConseiller" value="${InfoConseiller}"><br>
  </fieldset> 
 
<h2>Information relative aux comptes bancaires </h2>  
  <fieldset>    
    <legend>Compte Courant</legend>    
      <label for="soldeCC">Solde Compte</label>
      <input type="text" id="soldeCC" name="soldeCC" value=""><br>
      <label for="dateOuvertureCC">Date d'ouverture</label>
      <input type="date" id="dateOuvertureCC" name="dateOuvertureCC" placeholder="DD/MM/YYY" value="" ><br> 
      <label for="decouvertA">Découvert autorisé</label>
      <input type="text" id="decouvertA" name="decouvertA" value="" ><br>      
  </fieldset> 
  <fieldset>    
    <legend>Compte Epargne </legend>    
      
      <label for="soldeCE">Solde Compte</label>
      <input type="text" id="soldeCE" name=""soldeCE"><br>
      
      <label for="dateOuvertureCE">Date d'ouverture</label>
      <input type="date" id="dateOuvertureCE" name="dateOuvertureCE" placeholder="DD/MM/YYY" value="" ><br>
      
      <label for="tauxRemun">Taux de rémunération</label>
      <input type="text" id="tauxRemun" name="tauxRemun" value="0.03" readOnly><br>       
  </fieldset> 
  <p><input type="submit" value="Sauvegarder"></p>
</form>
	
	

</body>
</html>