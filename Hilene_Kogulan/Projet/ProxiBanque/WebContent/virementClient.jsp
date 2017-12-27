<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<h2>Virement du Compte Courant au Compte Epargne</h2>
<form action="ServletVirement" method="post">
  <p><i>Insérez le montant que vous souhaitez virer vers le compte Epargne</i></p>
 <fieldset> 
 <input type="text" name="idClient" id="idClient"" value="${asd.idClient}" readOnly><br>
 <legend>Compte Courant</legend>    
      <label for="soldeCC">Solde Compte</label>
      <input type="text" name="soldeCC" id="soldeCC" value="" readOnly><br>
      <label for="dateOuvertureCC">Date d'ouverture</label>
      <input type="date" id="dateOuvertureCC" name="dateOuvertureCC" placeholder="DD/MM/YYY" readOnly><br> 
      <label for="decouvertA">Découvert autorisé</label>
      <input type="text" id="decouvertA" name="decouvertA" value="1000" readOnly><br>      
  </fieldset> 
  
  <fieldset>    
    <legend>Compte Epargne</legend>    
      
      <label for="soldeCE">Solde Compte</label>
      <input type="text" id="soldeCE" name="soldeCE" value="" readOnly><br>
      
      <label for="dateOuvertureCE">Date d'ouverture</label>
      <input type="date" id="dateOuvertureCE" name="dateOuvertureCE" placeholder="DD/MM/YYY" readOnly><br>
      
      <label for="tauxRemun">Taux de rémunération</label>
      <input type="text" id="tauxRemun" name="tauxRemun" value="0.03" readOnly><br>       
  </fieldset> 
  
  <fieldset>
    <legend>Montant</legend>    
      <label for="montant">Montant du transfert<em>*</em></label>
		<input type="text" id="montant" name="montant"><br>
  </fieldset> 
 
  <p><input type="submit" value="Soummettre"></p>
</form>




</body>
</html>