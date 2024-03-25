<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	  <div class="form-box register">
                <h2 >Emprunter les livres</h2>
                <form action="emprunterLivres.jsp" method="post">
                    <div class="input-box">
                        <input type="text" required name="id">
                        <label for="text">id du livre</label>
                    </div>
                    <div class="input-box">
                        <input type="text" required name="nomLivre">
                        <label for="nomLivre">Titre de livre</label>
                    </div>
                    <div class="input-box">
                        <input type="text" required name="userName">
                        <label>userName</label>                       
                    </div>
					<section class="f">
                        <h2 class="subtitle article-subtitle"></h2>
                        <form action="https://httpbin.org/get" method="get" >
                        <button class="submit" type="register">Emprunter </button>
                     </section>
                   </form>
             </div>
</body>
</html>