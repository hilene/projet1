<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet" href="styleheader.css" />
<title>Page Conseiller</title>
<style>
table{
	border-collapse:collapse;
}
.en-tete{
background-color:RGB(168,197,36);
}
.ligne-impaire{
 background-color: #BBB;
}
.ligne-paire{
background-color: #EEE;
}
th{
	color: #FFF;
	font-weight: normal;
}
td,th{
	border: 1px solid black;
	padding: 10px 15px;
}

</style>
</head>
<body>
 <ul>
  <li><a href="accueilConseiller.jsp">Accueil</a></li>
  <li><a href="ajouterClient.jsp">Ajouter un Client</a></li>
  <li><a href="ajouterCompte.jsp">Ajouter un Compte</a></li>
  <li style="float:right"><a class="active" href="ServletLogin">${Conseiller.login}/Déconnexion</a></li>
</ul> 

<h1>Liste de vos clients</h1>
<table>
<tr class="en-tete">
	<td>idClient</td>
	<td>nomClient</td>
	<td>prenomClient</td>
	<td>telephone</td>
	<td>email</td>
	<td>Modification</td>
	<td>Virement</td>
</tr>
<c:forEach var="asd" items="${tableauClient}">
<tr class="ligne-paire">
	<td> <c:out value="${asd.idClient}"/></td>
	<td><c:out value="${asd.nomClient}"/></td>
	<td><c:out value="${asd.prenomClient}"/></td>
	<td><c:out value="${asd.emailClient}"/></td>
	<td><c:out value="${asd.telClient}"/></td>
	<td><a href="ServletModifClient?idclient=${asd.idClient}"
		 class="btn btn-info" role="button">Modification</a></td>
<td><a href="#"
		 class="btn btn-info" role="button">Virement</a></td>
<!--  	
	<td><a href="ServletVirement?idclient=${asd.idClient}"
		 class="btn btn-info" role="button">Virement</a></td>
	-->
</tr>

</c:forEach>

<tr class="ligne-impaire">
	<td>Test</td>
	<td>Test</td>
	<td>Test</td>
	<td>Test</td>
	<td>Test</td>
	<td>Test</td>
	<td>Test</td>
</tr>
</table>

</body>
</html>