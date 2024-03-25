<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="Dao.ContactDao" %>
<jsp:useBean id="obj" class="Classes.Contact"/>    
<jsp:setProperty property="*" name="obj"/>  
<% 
	int st;
	st=ContactDao.ajouter_message(obj);
	if (st >0)
	  {
		response.sendRedirect("home.jsp");
	}
	else{
		response.sendRedirect("ContactUs.jsp");
	}
%> 
</body>
</html>