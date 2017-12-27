<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet" href="styleheader.css" />
<title>Validation</title>
</head>
<body>
	<ul>
		  <li><a href="accueilConseiller.jsp">Accueil</a></li>
		  <li><a href="ajouterClient.jsp">Ajouter un Client</a></li>
		  <li><a href="ajouterCompte.jsp">Ajouter un Compte</a></li>
		  <li style="float: right"><a class="active" href="index.html">Déconnexion</a></li>
	</ul>
		<h1>
			<img src="success.png"
				alt="Validation"
				height="300px" width="300px"/>
		</h1>
		<p>
		${InfoTraitement}
		<form action="accueilConseiller.jsp" method="post">
<p><input type="submit" value="Retour"></p>
</body>
</html>