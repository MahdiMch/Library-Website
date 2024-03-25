<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="Dao.EtudiantDao" %>
<jsp:useBean id="u" class="Classes.Etudiant"/>
<jsp:setProperty property="*" name="u"/>
	<%
		boolean status;
	 	status = EtudiantDao.login(u);
	 	if (status==true){
	 		session = request.getSession();
	 		session.setAttribute("u",u);
	 		response.sendRedirect("home.jsp");
	 	}
	 	else{
	 		response.sendRedirect("login.jsp");
	 		out.println("mot de passe introuvable ou email introuvable");
	 		
	 	}
	%>
</body>
</html>