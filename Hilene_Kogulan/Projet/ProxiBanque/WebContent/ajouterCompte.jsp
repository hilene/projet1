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

<h2>Formulaire d'ajout Compte Courant/Compte Bancaire</h2>
<form action="ServletAjouterCompte" method="post">
  <p><i>Complétez le formulaire. Les champs marqué par </i><em>*</em> sont <em>obligatoires</em></p>
  <fieldset>    
    <legend>Information Client</legend>  
    <label for="idClient">Id Client</label>  
    <input type="text" id="idClient" name="idClient" required><br>
  </fieldset>    
  <fieldset>    
    <legend>Compte Courant<input id="checkBox" type="checkbox" name="checkboxCC" value="1" onchange="allowUpdate(this)"></legend>    
      <label for="soldeCC">Solde Compte</label>
      <input type="text" name="soldeCC" id="soldeCC" value="" readOnly><br>
      <label for="dateOuvertureCC">Date d'ouverture</label>
      <input type="date" id="dateOuvertureCC" name="dateOuvertureCC" placeholder="DD/MM/YYY" readOnly><br> 
      <label for="decouvertA">Découvert autorisé</label>
      <input type="text" id="decouvertA" name="decouvertA" value="1000" readOnly><br>      
  </fieldset> 
  <fieldset>    
    <legend>Compte Epargne <input id="checkBox" type="checkbox" name="checkboxCE" value="1" onchange="allowUpdate2(this)"></legend>    
      
      <label for="soldeCE">Solde Compte</label>
      <input type="text" id="soldeCE" name="soldeCE" value="" readOnly><br>
      
      <label for="dateOuvertureCE">Date d'ouverture</label>
      <input type="date" id="dateOuvertureCE" name="dateOuvertureCE" placeholder="DD/MM/YYY" readOnly><br>
      
      <label for="tauxRemun">Taux de rémunération</label>
      <input type="text" id="tauxRemun" name="tauxRemun" value="0.03" readOnly><br>       
  </fieldset> 
  <p><input type="submit" value="Soummettre"></p>
</form>
</body>
<script type="text/javascript">
function allowUpdate(element){
	if(element.checked){
		document.getElementById("soldeCC").readOnly = false; 
		document.getElementById("dateOuvertureCC").readOnly = false; 
		document.getElementById("decouvertA").readOnly = false; 
	}else{
		document.getElementById("soldeCC").readOnly = true; 
		document.getElementById("soldeCC").value="";
		document.getElementById("dateOuvertureCC").readOnly = true; 
		document.getElementById("dateOuvertureCC").value="";
		document.getElementById("decouvertA").readOnly = true; 
		document.getElementById("decouvertA").value="1000";
	}
}
function allowUpdate2(element){
	if(element.checked){
		document.getElementById("soldeCE").readOnly = false; 
		document.getElementById("dateOuvertureCE").readOnly = false; 
		document.getElementById("tauxRemun").readOnly = false; 
	}else{
		document.getElementById("soldeCE").readOnly = true; 
		document.getElementById("soldeCE").value="";
		document.getElementById("dateOuvertureCE").readOnly = true; 
		document.getElementById("dateOuvertureCE").value="";
		document.getElementById("tauxRemun").readOnly = true; 
		document.getElementById("tauxRemun").value="0.03";
	}
}
</script>
</html>