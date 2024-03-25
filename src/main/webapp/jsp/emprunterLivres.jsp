<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>emprunterLivres</title>
</head>
<body>
<%@page import="Dao.OrderDAO" %>
<jsp:useBean id="obj" class="Classes.Order"/>    
<jsp:setProperty property="*" name="obj"/>  
<% 
	int st;
	st=OrderDAO.newOrder(obj);
	if (st >0)
	  {
		response.sendRedirect("home.jsp");
	}
	else{
		response.sendRedirect("booking.jsp");
	}
%> 
</body>
</html>