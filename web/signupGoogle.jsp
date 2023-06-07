<%-- 
    Document   : signupGoogle
    Created on : May 31, 2023, 12:16:35 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - codingnepalweb.com -->
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Responsive Login and Signup Form </title>

        <!-- CSS -->
        <link rel="stylesheet" href="style.css">

        <!-- Boxicons CSS -->
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            /* Google Fonts - Poppins */
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap');

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }

            .container {
                height: 100vh;
                width: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
                background-color: #4070f4;
                column-gap: 30px;
            }

            .form {
                position: absolute;
                max-width: 430px;
                width: 100%;
                padding: 30px;
                border-radius: 6px;
                background: #FFF;
            }

            header {
                font-size: 28px;
                font-weight: 600;
                color: #232836;
                text-align: center;
            }

            form {
                margin-top: 30px;
            }

            .form .field {
                position: relative;
                height: 50px;
                width: 100%;
                margin-top: 20px;
                border-radius: 6px;
            }

            .field input,
            .field button {
                height: 100%;
                width: 100%;
                border: none;
                font-size: 16px;
                font-weight: 400;
                border-radius: 6px;
            }

            .field input {
                outline: none;
                padding: 0 15px;
                border: 1px solid#CACACA;
            }

            .field button {
                color: #fff;
                background-color: #0171d3;
                transition: all 0.3s ease;
                cursor: pointer;
            }

        </style>

    </head>

    <body style="background-color: #4070f4;">
        <section class="container forms">
            <div class="form login">
                <div class="form-content">
                    <header>
                        <div class="d-flex flex-row">
                            <p style="margin-top: 10px;">Singup With Google</p>
                            <div class="img">
                                <img src="images/google.png" alt="">
                            </div>
                        </div>
                    </header>

                    <form action="" method="POST">
                        <div class="field input-field">
                            <input type="text" placeholder="Username" class="input">
                        </div>
                        <div class="field input-field">
                            <input type="email" placeholder="Email" class="input">
                        </div>
                        <div class="field button-field">
                            <button>Signup</button>
                        </div>
                    </form>
                </div>
            </div>
    </body>

</html>
