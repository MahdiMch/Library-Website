<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="Dao.LivreDao" %>
<jsp:useBean id="book" class="Classes.Livre"/>    
<jsp:setProperty property="*" name="book"/>  
<% 
		int st;
		st = LivreDao.ajouterLivre(book);
		if (st>0)
			{
			response.sendRedirect("home_admin.jsp");
			}
		else {
			response.sendRedirect("ajouterLivre.jsp");
		}
%> 
</body>
</html>