<h3>Voici les informations lues dans le fichier fragmentIncluAvecBaliseInclude.jsp:</h3>
<p>
<%
	String bonjour = "bonjour tout le monde";
%>
<p>
	<%=bonjour %>
</p>
<!-- 
	il est ici impossible de lire la variable variableUtiliseeDansFragment.
	En effet, elle n'est pas transmise lors de l'include dynamique.
	Pour pour pouvoir la lire, il faudrait soit :
		-la transf�rer en attribut de requ�te (request.setAttribute/request.getAttribute)
		-la transf�rer � l'aide de la balise jsp:param. La lecture se faisant avec request.getParameter()
-->

<%-- 	<%=variableUtiliseeDansFragment %> Erreur de compilation--%>
<p>
	Lecture du param�tre "parametre" : <%=request.getParameter("parametre") %>
</p>
<p>
	Lecture de l'attribut "attribut" : <%=request.getAttribute("attribut") %>
</p>
						