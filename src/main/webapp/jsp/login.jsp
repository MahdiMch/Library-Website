<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="author" content="Mahdi Mcheihi">
        <meta name="description" content="This page contains all the books you need ">
        <title>Bibliothèque polytechnique </title>
        <link rel="stylesheet" href="./css/login.css" type="text/css">
        <link rel="icon" href="icon.jpg" type ="image/x-icon">
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    </head>
    <body>
   
        <header>
            <h2 class="logo">BibEPT</h2>
            <nav class="navigation">
                <a href="garde.jsp">Home</a>
                <a href="about.jsp">About</a>
               
                <a href="ContactUs.jsp">Contact</a>
                <button class="btnLogin-popup">Login</button>

                
            </nav>
        </header>
        <div class="wrapper">
            <span class="icon-close"><ion-icon name="close-circle"></ion-icon></span>
            <div class="form-box login">
                <h2 >Login</h2>
                <form action="index.jsp" , method="post">
                    <div class="input-box">
                        <span class="icon"><ion-icon name="email"></ion-icon>
                        </span>
                        <input type="email" required name="email">
                        <label for="E-mail">E-mail</label>

                    </div>
                    <div class="input-box">
                        <span class="icon"><ion-icon name="lock-closed"></ion-icon>
                        </span>
                        <input type="password" required name="password">
                        <label>password</label>
                        
                    </div>
                    <section class="f">
                        <h2 class="subtitle article-subtitle"></h2>
                        <form action="https://httpbin.org/get" method="get" >
                            <button class="submit" type="submit">Submit </button>
                            <p class="L"><a href="F">Forgot your password ?</a></p>
                            <div class="O">
                            <p class="M">Don't have an account?<a href="#" class="register-link">Register</a></p>
                            </div>
                        </form>
                        </section>
                </form>
            </div>
            <div class="form-box register">
                <h2 >Registration</h2>
                <form action="registration.jsp">
                    <div class="input-box">
                        <span class="icon"><ion-icon name="userName"></ion-icon>
                        </span>
                        <input type="text" required name="userName">
                        <label for="text">Username</label>

                    </div>
                    <div class="input-box">
                        <span class="icon"><ion-icon name="email"></ion-icon>
                        </span>
                        <input type="email" required name="email">
                        <label for="E-mail">E-mail</label>

                    </div>
                    <div class="input-box">
                        <span class="icon"><ion-icon name="lock-closed"></ion-icon>
                        </span>
                        <input type="password" required name="password">
                        <label>password</label>
                        
                    </div>
                    <div class="input-box">
                        <span class="icon"><ion-icon name="lock-closed"></ion-icon>
                        </span>
                        <input type="password" required>
                        <label>Confirm your password</label>
                        
                    </div>
                    <section class="f">
                        <h2 class="subtitle article-subtitle"></h2>
                        <form action="https://httpbin.org/get" method="get" >
                            <button class="submit" type="register">Register </button>
                            <div class="Pc"><p>Already have an account ?</p><a href="login.jsp" class="login-link">Login</a></div>
                        </form>
                        </section>
                </form>
            </div>
        </div>
    <script src="project.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>  
    <hr>
    <br><br>
    <footer>
        <div class="CP"><p class="mm"> Copyright © 2023 Ecole Polytechnique de Tunisie </p></div>
         
    </footer>
    </body>
</html>