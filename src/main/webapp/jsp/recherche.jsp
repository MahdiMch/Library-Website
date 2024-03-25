<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@page import="Dao.LivreDao" %>
	<%@page import="Classes.Livre" %>
	<%@page import="java.util.List" %>
	<%@page import="java.util.ArrayList" %>
	<%
		try{
		String s = request.getParameter("msg");
		Livre li = LivreDao.recherche(s);
	%>
	<%=li.getNomLivre()%>
	<%=li.getNomsAuteurFk() %>
	<%=li.getDomaineIdFk() %>
	<%=li.getSousDomaineIdFk() %>
	<%=li.getEdition() %>
	
	<%}catch(Exception e){System.out.println(e);} %>
</body>
</html>