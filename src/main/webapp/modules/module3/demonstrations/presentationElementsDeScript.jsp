<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%!
//déclarations
	private int nombreAppel;

//Getter/Setter (non générés automatiquement)
	private int getNombreAppel()
	{
		return this.nombreAppel;
	}
	
	private void setNombreAppel(int nombreAppel)
	{
		this.nombreAppel = nombreAppel;
	}
%>  
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Présentation des éléments de script</title>
	</head>
	<body>
		<%
//Scriplets
		this.setNombreAppel(this.getNombreAppel()+1);
		%>
		Nombre d'appel de la JSP :
		<input type="text" value="<%=this.getNombreAppel()%>"/>
		<a href="presentationElementsDeScript.jsp">Actualiser</a>
		<a href="premiereJSP.jsp">Retour</a>
	</body>
	</html>