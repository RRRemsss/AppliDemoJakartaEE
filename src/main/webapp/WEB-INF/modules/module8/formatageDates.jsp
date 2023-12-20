<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.GregorianCalendar"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formatage des dates</title>
</head>
<body>
	<h2>L'heure en France</h2>
		<p>
			L'affichage de la date actuelle avec la langue par défaut:
			<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" dateStyle="full"/>
		</p>
		<p>
			L'affichage de l'heure actuelle avec la langue par défaut:
			<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" type="time" timeStyle="short"/>
		</p>
		<p>
			L'affichage de la date avec la langue anglaise:
			<fmt:setLocale value="en"/>
			<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" dateStyle="full"/>
		</p>
			<p>
			L'affichage de l'heure actuelle avec la langue anglaise:
			<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" type="time" timeStyle="full"/>
		</p>
			
	<h2>L'heure en Argentine</h2>
		<fmt:timeZone value="Argentina/Buenos Aires">
		<p> 
			L'affichage de la date actuelle en Argentine avec la langue espagnole :
			<fmt:setLocale value="es"/>
			<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" dateStyle="full"/>
			<fmt:formatDate value="${GregorianCalendar.getInstance().getTime()}" type="time" timeStyle="short"/>
		</p>
		</fmt:timeZone>
	<p>
		<a href="demonstrations/demonstration2.html">Retour</a>
	</p>
</body>
</html>