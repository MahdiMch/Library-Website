<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="Dao.LibrarianDao" %>
<jsp:useBean id="u" class="Classes.Librarian" />
<jsp:setProperty property="*" name="u"/>
	<%
		boolean status;
	 	status = LibrarianDao.login(u);
	 	if (status==true){
	 		session = request.getSession();
	 		session.setAttribute("u",u);
	 		
                        response.sendRedirect("home_admin.jsp");
	 	}
	 	else{
	 		response.sendRedirect("login_admin.jsp");
	 		out.println("mot de passe introuvable ou email introuvable");
	 		
	 	}
	%>
</body>
</html>