<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="Dao.LibrarianDao"%>  
<jsp:useBean id="obj" class="Classes.Librarian"/>    
<jsp:setProperty property="*" name="obj"/>  
  
<%  
	boolean status = LibrarianDao.login(obj);
	if (status == false){
	int st=LibrarianDao.register(obj);
	session = request.getSession();
	if(st > 0)  {
		String msg ;
		msg="Successfully registred";
		session.setAttribute("msg",msg);
		response.sendRedirect("login_admin.jsp");
	}
	else{
		String msg ;
		msg = "An error has occured";
		session.setAttribute("msg",msg);
		response.sendRedirect("login_admin.jsp");
	}}
	else{
		String msg ;
		msg = "this email is already used";
		session.setAttribute("msg",msg);
		response.sendRedirect("registration_admin.jsp");
	}
%>  
</body>
</html>