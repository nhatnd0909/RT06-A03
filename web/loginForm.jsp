<%-- 
    Document   : loginForm
    Created on : Jun 26, 2023, 12:42:29 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Email and Password Validation</title>
    <!-- Boxicons CSS -->
    <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet" />
    <style>
        /* Google Fonts - Poppins */
        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap");

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", sans-serif;
        }

        body {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: #4070f4;
        }

        .container {
            position: relative;
            max-width: 470px;
            width: 100%;
            padding: 25px;
            border-radius: 12px;
            background-color: #fff;
        }

        .container header {
            font-size: 50px;
            font-weight: 700;
            color: #337ab7;
            margin-top: 20px;
            display: flex;
            justify-content: center;

        }

        .container form {
            margin-top: 30px;
        }

        form .field {
            margin-bottom: 20px;
        }

        form .input-field {
            position: relative;
            height: 55px;
            width: 100%;
        }

        .input-field input {
            height: 100%;
            width: 100%;
            outline: none;
            border: none;
            border-radius: 8px;
            padding: 0 15px;
            border: 1px solid #d1d1d1;
        }

        .invalid input {
            border-color: #d93025;
        }

        .input-field .show-hide {
            position: absolute;
            right: 13px;
            top: 50%;
            transform: translateY(-50%);
            font-size: 18px;
            color: #919191;
            cursor: pointer;
            padding: 3px;
        }

        .field .error {
            display: flex;
            align-items: center;
            margin-top: 6px;
            color: #d93025;
            font-size: 13px;
            display: none;
        }

        .invalid .error {
            display: flex;
        }

        .error .error-icon {
            margin-right: 6px;
            font-size: 15px;
        }

        .create-password .error {
            align-items: flex-start;
        }

        .create-password .error-icon {
            margin-top: 4px;
        }

        .button {
            margin: 25px 0 6px;
        }

        .button input {
            color: #fff;
            font-size: 16px;
            font-weight: 400;
            background-color: #4070f4;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .button input:hover {
            background-color: #0e4bf1;
        }
        .last{
            display: flex;
            justify-content: center;
        }
    </style>
    <meta name="google-signin-client_id" content="YOUR_CLIENT_ID.apps.googleusercontent.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <header>Login</header>
        <form action="loginform" method="POST">
            <p class="" style="color: red ;margin-bottom: 20px">${mess}</p>
            <div class="field email-field">
                <div class="input-field">
                    <input type="text" name="username" placeholder="Enter username" class="" value="${username}" required/>
                </div>
            </div>
            <div class="field create-password">
                <div class="input-field">
                    <input id="id_password" name="password" type="password" placeholder="Enter password" 
                           class="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
                           title="Please enter atleast 8 charatcer with number, symbol, small and capital letter." value="${password}" required/>
                    <i id="togglePassword" class="bx bx-hide show-hide"></i>
                </div>
                <span class="error password-error">
                    <i class="bx bx-error-circle error-icon"></i>
                    <p class="error-text">
                        Please enter atleast 8 charatcer with number, symbol, small and
                        capital letter.
                    </p>
                </span>
            </div>
            <div style="padding: 10px 0;">
                <a href="forgotpassord" style="text-decoration: none;">Forgot password?</a>
            </div>
            <div class="input-field button">
                <input type="submit" value="Login" />
            </div>
        </form>
        <div class="last">
            <div style="padding: 10px 0">
                <p>Not a member ? <a href="register" style="text-decoration: none;color: #337ab7">Register</a></p>
            </div>
        </div>
        <!--<div id="my-signin2"></div>-->
    </div>
    <!-- JavaScript -->
    <script>
        const togglePassword = document.querySelector('#togglePassword');
        const password = document.querySelector('#id_password');

        togglePassword.addEventListener('click', function (e) {
            // toggle the type attribute
            const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
            password.setAttribute('type', type);
            this.classList.toggle('bx-show');
        });
    </script>
    <script>
        function onSuccess(googleUser) {
            console.log('Logged in as: ' + googleUser.getBasicProfile().getName());
        }
        function onFailure(error) {
            console.log(error);
        }
        function renderButton() {
            gapi.signin2.render('my-signin2', {
                'scope': 'profile email',
                'width': 240,
                'height': 50,
                'longtitle': true,
                'theme': 'dark',
                'onsuccess': onSuccess,
                'onfailure': onFailure
            });
        }
    </script>

    <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
</body>
</html>
