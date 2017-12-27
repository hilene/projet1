<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet" href="styleheader.css" />
<style type="text/css">
.my_content_container a {
    border-bottom: 1px solid #777777;
    border-left: 1px solid #000000;
    border-right: 1px solid #333333;
    border-top: 1px solid #000000;
    color: #000000;
    display: block;
    height: 2.5em;
    padding: 0 1em;
    width: 5em;       
    text-decoration: none;       
}
// :hover and :active styles left as an exercise for the reader.
</style>

<title>Echec d'authentification</title>
</head>
<body>
		<h1>
			<img src="fail.png"
				alt="Validation"
				height="300px" width="300px"/>
		</h1>
		<h2>Echec d'authentification Conseiller</h2>
		<em><i>Veuillez essayer à nouveau</i></em>
<form action="index.html" method="post">
<p><input type="submit" value="Retour"></p>
</form>
</body>
</html>