<%-- 
    Document   : newPassword
    Created on : Jun 28, 2023, 8:12:10 PM
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
            font-size: 30px;
            font-weight: 700;
            color: #333;
            margin-top: 20px;

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
        }
    </style>
    <meta name="google-signin-client_id" content="YOUR_CLIENT_ID.apps.googleusercontent.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <header>New Password</header>
        <form action="newpassword" method="POST">
            <p class="" style="color: red ;margin-bottom: 20px">${mess}</p>
            <div class="field create-password">
                <div class="field create-password">
                    <div class="input-field">
                        <input name="username" type="text" placeholder="Create password" 
                               class="password"
                               value="${sessionScope.account.userName}" required disabled/>
                    </div>
                </div>
                <div class="field create-password">
                    <div class="input-field">
                        <input name="password" type="password" placeholder="Create password" 
                               class="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
                               title="Please enter atleast 8 charatcer with number, symbol, small and capital letter." value="${password}" required/>
                        <i class="bx bx-hide show-hide"></i>
                    </div>
                    <span class="error password-error">
                        <i class="bx bx-error-circle error-icon"></i>
                        <p class="error-text">
                            Please enter atleast 8 charatcer with number, symbol, small and
                            capital letter.
                        </p>
                    </span>
                </div>
                <div class="field confirm-password">
                    <div class="input-field">
                        <input name="confirmPass" type="password" placeholder="Create password" 
                               class="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
                               title="Please enter atleast 8 charatcer with number, symbol, small and capital letter." value="${confirmPass}" required/>
                        <i class="bx bx-hide show-hide"></i>
                    </div>
                    <span class="error cPassword-error">
                        <i class="bx bx-error-circle error-icon"></i>
                        <p class="error-text">Password don't match</p>
                    </span>
                </div>
                <div class="input-field button">
                    <input type="submit" value="Submit" />
                </div>
        </form>
        <div class="last">
            <div style="padding: 10px 0">
                <a class="btn-back" href="loginform" style="text-decoration: none;">Back to sign in</a>
            </div>
            <div style="padding: 10px 0; margin-left: 120px">
                <a href="register" style="text-decoration: none;">Create new account</a>
            </div>
        </div>
    </div>
    <!-- JavaScript -->
    <script>
        const form = document.querySelector("form"),
                passField = form.querySelector(".create-password"),
                passInput = passField.querySelector(".password"),
                cPassField = form.querySelector(".confirm-password"),
                cPassInput = cPassField.querySelector(".cPassword");
        const eyeIcons = document.querySelectorAll(".show-hide");
        eyeIcons.forEach((eyeIcon) => {
            eyeIcon.addEventListener("click", () => {
                const pInput = eyeIcon.parentElement.querySelector("input"); //getting parent element of eye icon and selecting the password input
                if (pInput.type === "password") {
                    eyeIcon.classList.replace("bx-hide", "bx-show");
                    return (pInput.type = "text");
                }
                eyeIcon.classList.replace("bx-show", "bx-hide");
                pInput.type = "password";
            });
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

