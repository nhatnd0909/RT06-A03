<%-- 
    Document   : detailBooking
    Created on : Jun 15, 2023, 12:18:41 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
                        <p class="breadcrumbs"><span class="mr-2"><a href="home">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Detail Booking <i class="ion-ios-arrow-forward"></i></span></p>
                        <h1 class="mb-3 bread">Detail Booking</h1>
                    </div>
                </div>
            </div>
        </section>


        <div class="container">
            <div class="py-5 text-center">
                <h2>Detail Booking</h2>
            </div>
            <div class="row g-5 d-flex justify-content-center">     
                <div class="col-md-8 col-lg-8">
                    <form action="detailbooking" method="POST">
                        <div class="row g-3">
                            <div class="col-md-6 form-group">
                                <label class="form-label">Rent date</label> <br>
                                <input name="fromDay" class="form-control form-control-lg" type="date" >
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="form-label">Number of days rent</label>
                                <select name="numberDay" class="form-control">
                                    <option value="1">1 day</option>
                                    <c:forEach begin="2" end="31" step="1" var="i">
                                        <option value="${i}">${i} days</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="form-label">Rent hour</label>
                                <input name="fromHour" class="form-control" type="datetime-local">
                            </div>
                            <div class="col-md-6 form-group">
                                <label class="form-label">Number of days rent</label>
                                <select name="numberHour" class="form-control">
                                    <option value="1">1 hour</option>
                                    <c:forEach begin="2" end="24" step="1" var="i">
                                        <option value="${i}">${i} hours</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="form-label text-dark">Car pick up location</label> <br>
                            </div>
                            <div class="col-12">
                                <label class="form-label">Address</label>
                                <input name="address" type="text" class="form-control">
                            </div>
                            <div class="col-md-4 form-group">
                                <label for="country" class="form-label">Province/ City</label>
                                <input name="city" type="text" class="form-control" id="address">    
                            </div>
                            <div class="col-md-4 form-group">
                                <label for="state" class="form-label">District</label>
                                <input name="district" type="text" class="form-control">   
                            </div>
                            <div class="col-md-4 form-group">
                                <label class="form-label">Wards</label>
                                <input name="wards" type="text" class="form-control">   
                            </div>

                            <div class="col-md-12 form-group">
                                <label class="form-label text-dark">Car pick up location</label> <br>
                            </div>
                            <div class="col-md-12 form-group">
                                <div class="card">
                                    <div style="margin: 5px">
                                        <p class="" style="font-size: 13px">Pick-up location</p>
                                        <p class="" style="color: black">Hải Châu - Đà Nẵng</p>
                                        <p style="font-size: 11px">Car owners are supported to deliver the car to the place. Specific address will be displayed after deposit</p>
                                    </div>
                                </div>
                            </div>
                            <!--                            <div class="col-12">
                                                            <div class="card" style="width: 100%;">
                                                                <div class="card-body">
                                                                    <h5 class="card-title">Rent cost</h5>
                                                                    <div class="clearfix" style="">
                                                                        <p class="float-left" style="color: black">Day rent:</p>
                                                                        <p class="float-right" style="color: black"><span>${car.pricePerDay}K</span>/ Day</p>
                                                                    </div>
                                                                    <div class="clearfix" style="">
                                                                        <p class="float-left" style="color: black">Hour rent:</p>
                                                                        <p class="float-right" style="color: black;"><span>${car.pricePerHour}K</span>/ Hour</p>
                                                                    </div>
                                                                    <div class="clearfix" style="">
                                                                        <p class="float-left" style="color: black">Maintenance fee</p>
                                                                        <p class="float-right" style="color: black;"><span>50K</span></p>
                                                                    </div>
                                                                    <div class="clearfix" style="">
                                                                        <h4 class="float-left" style="color: black">Total</h4>
                                                                        <h4 class="float-right" style="color: black;"><span>50K</span></h4>
                                                                    </div>
                                                                </div>
                                                            </div>   
                                                        </div>                       -->
                        </div>
                        <hr class="my-4">
                        <h4 class="mb-3">Payment</h4>
                        <div class="my-3">
                            <div class="form-check">
                                <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked required>
                                <label class="form-check-label" for="credit">Credit card</label>
                            </div>
                            <div class="form-check">
                                <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required>
                                <label class="form-check-label" for="debit">Direct payment</label>
                            </div>
                        </div>
                        <hr class="my-4">
                        <button class="w-100 btn btn-danger btn-lg" type="submit" style="margin-bottom: 50px">Continue to checkout</button>
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
