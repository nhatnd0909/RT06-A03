<%-- 
    Document   : login.jsp
    Created on : May 25, 2023, 10:47:08 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Login & Signup</title>
        <link rel="stylesheet" href="./css/css/login.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>

    <body>
        <section class="wrapper">
            <div class="form signup">
                <header>Signup</header>       
                <form action="signup" method="POST">
                    <p class="text-warning" style="font-size: 25px">${messSignup}</p>
                    <input type="text" name="username" value="${userSignup}" placeholder="UserName" required />
                    <input type="password" name="password" value="${passSignup}" placeholder="Password" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,32}$" required />        
                    <input type="password" name="repassword" value="${repassSignup}" placeholder="Repeat Password" required />
                    <lable style="color: white">*Password must contains 8-32 characters, at least 1 uppercase 1 lowercase</lable>
                    <input type="submit" value="Signup" />
                </form>
            </div>

            <div class="form login">
                <header>Login</header>

                <form action="login" method="POST" id="login">
                    <p class="text-danger" style="font-size: 25px">${messLogin}</p>
                    <input type="text" name="username" placeholder="UserName" value="${userLogin}" required />
                    <input type="password" name="password" placeholder="Password" value="${passLogin}" required />
                    <a href="#">Forgot password?</a>
                    <input type="submit" value="Login" />
                </form>
            </div>

            <script>
                const wrapper = document.querySelector(".wrapper"),
                        signupHeader = document.querySelector(".signup header"),
                        loginHeader = document.querySelector(".login header");

                loginHeader.addEventListener("click", () => {
                    wrapper.classList.add("active");
                });
                signupHeader.addEventListener("click", () => {
                    wrapper.classList.remove("active");
                });
            </script>
        </section>
    </body>

</html>
