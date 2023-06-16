<%-- 
    Document   : payment
    Created on : Jun 15, 2023, 5:58:02 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <head>
        <title>Book Car</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/ionicons.min.css">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">
        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
        <style >
            h2 {
                font-size: 40px;
                background: linear-gradient(to left, #660066 0%, #ff3300 100%);
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="home"><img src="images/car-rent.png"/> Car<span>Book</span></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item"><a href="home" class="nav-link">Home</a></li>
                        <li class="nav-item"><a href="about" class="nav-link">About</a></li>
                        <li class="nav-item"><a href="pricing" class="nav-link">Pricing</a></li>
                        <li class="nav-item active"><a href="car" class="nav-link">Cars</a></li>
                        <li class="nav-item"><a href="contact" class="nav-link">Contact</a></li>
                            <c:if test="${sessionScope.id != null}">
                            <li class="nav-item"><a href="profile?id=${sessionScope.id}" class="nav-link">Profile</a></li> 
                            <li class="nav-item"><a href="logout" class="nav-link">Logout</a></li>
                            </c:if>
                            <c:if test="${sessionScope.id == null}">
                            <li class="nav-item"><a href="login" class="nav-link">Login</a></li>
                            </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- END nav -->
        <section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('images/banner.jpg');" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
                    <div class="col-md-9 ftco-animate pb-5">
                        <p class="breadcrumbs"><span class="mr-2"><a href="home">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Payment <i class="ion-ios-arrow-forward"></i></span></p>
                        <h1 class="mb-3 bread">Payment</h1>
                    </div>
                </div>
            </div>
        </section>


        <div class="container">
            <div class="py-5 text-center">
                <h2>Payment</h2>
            </div>
            <div class="row g-5 d-flex justify-content-center">
                <div class="col-md-7 col-lg-7">
                    <form action="" method="">
                        <div class="row g-3">
                            <div class="col-12">
                                <div class="card" style="width: 100%;">
                                    <div class="card-body">
                                        <h3 class="card-title">Order Detail</h3>
                                        <hr class="my-4">

                                        <div class="clearfix" style="">
                                            <h4 class="card-title float-left">Car name</h4>
                                            <p class="float-right" style="color: black">${car.carName}</p>
                                        </div>
                                        <c:if test="${typeRentCar == 0}">
                                            <div class="clearfix" style="">
                                                <p class="float-left" style="color: black">Price per Day</p>
                                                <p class="float-right" style="color: black"><span>${car.pricePerDay}K</span>/ Day</p>
                                            </div>
                                        </c:if>
                                        <c:if test="${typeRentCar == 1}">
                                            <div class="clearfix" style="">
                                                <p class="float-left" style="color: black">Price per Hour</p>
                                                <p class="float-right" style="color: black;"><span>${car.pricePerHour}K</span>/ Hour</p>
                                            </div>
                                        </c:if>
                                        <c:if test="${typeRentCar == 0}">
                                            <div class="clearfix" style="">
                                                <p class="float-left" style="color: black">Number of rental days</p>
                                                <p class="float-right" style="color: black;">${NumberDayOrder} Days</p>
                                            </div>
                                        </c:if>
                                        <c:if test="${typeRentCar == 1}">
                                            <div class="clearfix" style="">
                                                <p class="float-left" style="color: black">Number of rental hours</p>
                                                <p class="float-right" style="color: black;">${NumberHourOrder} hours</p>
                                            </div>
                                        </c:if>

                                        <div class="clearfix" style="">
                                            <p class="float-left" style="color: black">Mortgage fee</p>
                                            <p class="float-right" style="color: black;"><span>10.000K</span></p>
                                        </div>
                                        <c:if test="${typeReceiveCar == 0}">
                                            <div class="clearfix" style="">
                                                <p class="float-left" style="color: black">Car shipping fee</p>
                                                <p class="float-right" style="color: black;"><span>0K</span></p>
                                            </div>
                                        </c:if>
                                        <c:if test="${typeReceiveCar == 1}">
                                            <div class="clearfix" style="">
                                                <p class="float-left" style="color: black">Car shipping fee</p>
                                                <p class="float-right" style="color: black;"><span>50K</span></p>
                                            </div>
                                        </c:if>

                                        <hr class="my-4">
                                        <div class="clearfix" style="">
                                            <h4 class="float-left" style="color: black">Total</h4>
                                            <h4 class="float-right" style="color: black;"><span>${total}K</span></h4>  
                                        </div>
                                    </div>
                                </div>   
                            </div>                       
                        </div>
                        <button class="w-100 btn btn-danger btn-lg" type="submit" style="margin-bottom: 50px">Purchase orders</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.timepicker.min.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
