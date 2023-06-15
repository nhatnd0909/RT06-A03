<%-- 
    Document   : home.jsp
    Created on : May 25, 2023, 10:16:27 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home</title>
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
    </head>
    <body>
        <i class="fa-regular fa-house"></i>
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="home"><img src="images/car-rent.png"/> Car<span>Book</span></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active"><a href="home" class="nav-link"> Home</a></li>
                        <li class="nav-item"><a href="about" class="nav-link">About</a></li>
                        <li class="nav-item"><a href="pricing" class="nav-link">Pricing</a></li>
                        <li class="nav-item"><a href="car" class="nav-link">Cars</a></li>
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

        <div class="hero-wrap ftco-degree-bg" style="background-image: url('images/banner.jpg');" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text justify-content-start align-items-center justify-content-center">
                    <div class="col-lg-8 ftco-animate">
                        <div class="text w-100 text-center mb-md-5 pb-md-5">
                            <h1 class="mb-4">Fast &amp; Easy Way To Rent A Car</h1>
                            <p style="font-size: 18px;">A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <section class="ftco-section ftco-no-pt bg-light">
            <div class="container">
                <div class="row no-gutters">
                    <div class="col-md-12	featured-top">
                        <div class="row no-gutters">
                            <div class="col-md-4 d-flex align-items-center">
                            </div>
                            <div class="col-md-12 d-flex align-items-center">
                                <div class="services-wrap rounded-right w-100">
                                    <h3 class="heading-section mb-4">Better Way to Rent Your Perfect Cars</h3>
                                    <div class="row d-flex mb-4">
                                        <div class="col-md-3 d-flex align-self-stretch ftco-animate">
                                            <div class="services w-100 text-center">
                                                <div class="icon d-flex align-items-center justify-content-center"><img src="images/chooseCar.png" alt="alt"/></span></div>
                                                <div class="text w-100">
                                                    <h3 class="heading mb-2">Choose Car</h3>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-3 d-flex align-self-stretch ftco-animate">
                                            <div class="services w-100 text-center">
                                                <div class="icon d-flex align-items-center justify-content-center"><img src="images/location.png" alt="alt"/></div>
                                                <div class="text w-100">
                                                    <h3 class="heading mb-2">Choose Pickup Location</h3>
                                                </div>
                                            </div>      
                                        </div>
                                        <div class="col-md-3 d-flex align-self-stretch ftco-animate">
                                            <div class="services w-100 text-center">
                                                <div class="icon d-flex align-items-center justify-content-center"><img src="images/registration.png""/></div>
                                                <div class="text w-100">
                                                    <h3 class="heading mb-2">Complete The Registration Process</h3>
                                                </div>
                                            </div>      
                                        </div>


                                        <div class="col-md-3 d-flex align-self-stretch ftco-animate">
                                            <div class="services w-100 text-center">
                                                <div class="icon d-flex align-items-center justify-content-center"><img src="images/rental-car.png""/></div>
                                                <div class="text w-100">
                                                    <h3 class="heading mb-2">Reserve Your Rental Car</h3>
                                                </div>
                                            </div>      
                                        </div>
                                    </div>
                                    <p><a href="car" class="btn btn-primary py-3 px-4">Reserve Your Perfect Car</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
        <section class="ftco-section ftco-no-pt bg-light">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-12 heading-section text-center ftco-animate mb-5">
                        <span class="subheading">What we offer</span>
                        <h2 class="mb-2">Featured Vehicles</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="carousel-car owl-carousel">
                            <c:forEach items="${listFeeaturedCar}" var="list">
                                <div class="item">
                                    <div class="car-wrap rounded ftco-animate">
                                        <div class="img rounded d-flex align-items-end" style="background-image: url(images/${list.img});">
                                        </div>
                                        <div class="text">
                                            <h2 class="mb-0"><a href="#">${list.carName}</a></h2>
                                            <div class="d-flex mb-3">
                                                <span class="cat">${list.manufacturer}</span>
                                                <p class="price ml-auto">${list.pricePerDay}K <span>/day</span></p>
                                            </div>
                                            <p class="d-flex mb-0 d-block">
                                                <a href="bookcar?cid=${list.idCar}" class="btn btn-primary py-2 mr-1">Book now</a> 
                                                <a href="detail?cid=${list.idCar}" class="btn btn-secondary py-2 ml-1">Details</a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center mb-5">
                    <div class="col-md-7 text-center heading-section ftco-animate">
                        <span class="subheading">Services</span>
                        <h2 class="mb-3">Our Latest Services</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 col-sm-6 col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/logistics.png" alt="alt"/></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">Choose Pick Up Location</h3>
                                <p>Customers can choose a specific location when receiving the car. Car will deliver the car to the location on time.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-6 col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/clean.png" alt="alt"/></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">Free Car Cleaning</h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-6 col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/tools.png" alt="alt"/></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">On-site Repair</h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-6 col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/fuel.png" alt="alt"/></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">Fuel Transportation</h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center mb-5">
                    <div class="col-md-7 text-center heading-section ftco-animate">

                        <h2 class="mb-3">Why Choose Us?</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6 col-sm-6 col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/star.png" alt="alt"/></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">Reputation Brand</h3>
                                <p>Customers can choose a specific location when receiving the car. Car will deliver the car to the location on time.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-6 col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/car-icon.png" alt="alt"/></span></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">Material Facilities</h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-6 col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/smiling.png" alt="alt"/></span></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">Dedicated Service</h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-6 col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/best-price.png" alt="alt"/></span></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">Reasonable Pricing</h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="ftco-counter ftco-section img bg-light" id="section-counter">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-6 col-md-6 col-lg-3 justify-content-center counter-wrap ftco-animate">
                        <div class="block-18">
                            <div class="text text-border d-flex align-items-center">
                                <strong class="number" data-number="5">0</strong>
                                <span>Year <br>Experienced</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-md-6 col-lg-3 justify-content-center counter-wrap ftco-animate">
                        <div class="block-18">
                            <div class="text text-border d-flex align-items-center">
                                <strong class="number" data-number="${totalCar}">0</strong>
                                <span>Total <br>Cars</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-md-6 col-lg-3 justify-content-center counter-wrap ftco-animate">
                        <div class="block-18">
                            <div class="text text-border d-flex align-items-center">
                                <strong class="number" data-number="2590">0</strong>
                                <span>Happy <br>Customers</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-md-6 col-lg-3 justify-content-center counter-wrap ftco-animate">
                        <div class="block-18">
                            <div class="text d-flex align-items-center">
                                <strong class="number" data-number="67">0</strong>
                                <span>Total <br>Branches</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>	

        <footer class="ftco-footer ftco-bg-dark ftco-section">
            <div class="container">
                <div class="row mb-5">
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2"><a href="#" class="logo">Car<span>book</span></a></h2>
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                            <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4 ml-md-5">
                            <h2 class="ftco-heading-2">Information</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">About</a></li>
                                <li><a href="#" class="py-2 d-block">Services</a></li>
                                <li><a href="#" class="py-2 d-block">Term and Conditions</a></li>
                                <li><a href="#" class="py-2 d-block">Best Price Guarantee</a></li>
                                <li><a href="#" class="py-2 d-block">Privacy &amp; Cookies Policy</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Customer Support</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">FAQ</a></li>
                                <li><a href="#" class="py-2 d-block">Payment Option</a></li>
                                <li><a href="#" class="py-2 d-block">Booking Tips</a></li>
                                <li><a href="#" class="py-2 d-block">How it works</a></li>
                                <li><a href="#" class="py-2 d-block">Contact Us</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Have a Questions?</h2>
                            <div class="block-23 mb-3">
                                <ul>
                                    <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
                                    <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
                                    <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">

                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
            </div>
        </footer>
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
