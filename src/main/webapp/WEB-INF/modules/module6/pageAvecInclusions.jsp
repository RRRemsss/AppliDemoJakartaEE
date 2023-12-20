<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cette page est composée d'éléments inclus</title>
</head>
<body>
	
<!-- 
		La valeur de l'attribut file est un nom de fichier dans le système de fichier. 
		Ce n'est pas une URL.
		Il est à destination du Moteur Jasper 2 pour qu'il puisse le recopier dans le fichier pageAvecInclusion.jsp 
	-->
	<%@include file="entete.html" %>
	
	<%
		int variableUtiliseeDansFragment = 123;
	%>
	<%@include file="fragmentIncluAvecDirectiveInclude.jspf" %>
	
	<!-- 
		La valeur de l'attribut page est une URL.
	-->
	<%
		request.setAttribute("attribut", variableUtiliseeDansFragment);
	%>
	<jsp:include page="/WEB-INF/modules/module6/fragmentIncluAvecBaliseInclude.jsp">
		<jsp:param value="<%=variableUtiliseeDansFragment%>" name="parametre"/>
	</jsp:include>
	
	<div>
		<a href="demonstrations/demonstration1.html">Retour</a>
	</div>
	
	<%@include file="piedDePage.html" %>
</body>
</html>