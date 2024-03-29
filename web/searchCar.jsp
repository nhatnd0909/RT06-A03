<%-- 
    Document   : searchCar.jsp
    Created on : May 25, 2023, 11:07:49 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Search Your Car</title>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />

        <style>
            .searchBox {
                background: #fff;
                height: 60px;
                border-radius: 40px;
                border:solid 2px black ;
                padding: 10px;
                margin-bottom: 10px;
                width: 250px;
            }
            .searchButton {
                color: black;
                float: right;
                width: 40px;
                height: 40px;
                border-radius: 50%;
                background: #59b7ee;
                display: flex;
                justify-content: center;
                align-items: center;
                transition: 0.4s;
            }
            .searchInput {
                border: none;
                background: #fff;
                outline: none;
                float: left;
                padding: 0;
                color: black;
                font-size: 16px;
                transition: 0.4s;
                line-height: 40px;
                width: 170px;
                padding: 0 6px;

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
                        <!--                        <li class="nav-item"><a href="services" class="nav-link">Services</a></li>-->
                        <li class="nav-item"><a href="pricing" class="nav-link">Pricing</a></li>
                        <li class="nav-item active"><a href="car" class="nav-link">Cars</a></li>
                        <li class="nav-item"><a href="contact" class="nav-link">Contact</a></li>
                            <c:if test="${sessionScope.id != null}">
                            <li class="nav-item"><a href="profile?id=${sessionScope.id}" class="nav-link">Profile</a></li> 
                            <li class="nav-item"><a href="logout" class="nav-link">Logout</a></li>
                            </c:if>
                            <c:if test="${sessionScope.id == null}">
                            <li class="nav-item"><a href="loginform" class="nav-link">Login</a></li>
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
                        <p class="breadcrumbs"><span class="mr-2"><a href="home">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Cars <i class="ion-ios-arrow-forward"></i></span></p>
                        <h1 class="mb-3 bread">Search Car</h1>
                    </div>
                </div>
            </div>
        </section>


        <section class="ftco-section bg-light">
            <div class="container">
                <!--  -->
                <div class="container">  
                    <div class="clearfix">
                        <form action="search" method="GET">
                            <div class="d-flex float-left">
                                <div class="filter">
                                    <select class="form-control form-control-lg" name="manufacturer">                                        
                                        <option value="">Manufacturer</option>
                                        <c:forEach items="${listManufactory}" var="listManufactory">
                                            <option value="${listManufactory}">${listManufactory}</option>
                                        </c:forEach> 
                                    </select>
                                </div>
                                <div class="filter">
                                    <select class="form-control form-control-lg" name="type" style="margin-left: 10px">
                                        <option value="">Type</option>
                                        <c:forEach items="${listType}" var="listType">
                                            <option value="${listType}">${listType}</option>
                                        </c:forEach> 
                                    </select>
                                </div>
                                <div class="filter">
                                    <select class="form-control form-control-lg" name="pricePerDay" style="margin-left: 30px">
                                        <option value="0">Price per Day</option>
                                        <option value="1">Less than 800k</option>
                                        <option value="2">From 800k to 1.000k</option>
                                        <option value="3">From 1.000k to 1.500k</option>
                                        <option value="4">From 1.500k to 2.000k</option>
                                        <option value="4">More than 2.000k</option>
                                    </select>
                                </div>
                                <div class="filter">
                                    <select class="form-control form-control-lg" name="pricePerHour" style="margin-left: 40px">
                                        <option value="0">Price per Hour</option>
                                        <option value="1">Less than 40k</option>
                                        <option value="2">From 40k to 60k</option>
                                        <option value="3">From 60k to 80k</option>
                                        <option value="4">From 80k to 100k</option>
                                        <option value="4">More than 100k</option>
                                    </select>
                                </div>
                            </div>
                            <div class="float-left" style="margin: 20px 0">
                                <div class="searchBox">
                                    <input class="searchInput" value="${searchInput}" type="text" name="searchInput" placeholder="Search">
                                    <button class="searchButton" type="submit" href="#">
                                        <i class="material-icons">
                                            <i class="fa-solid fa-magnifying-glass"></i>
                                        </i>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>   
                <!--  -->

                <div class="row">
                    <c:forEach items="${listCar}" var="list">
                        <div class="col-md-4">
                            <div class="car-wrap rounded ftco-animate">
                                <div class="img rounded d-flex align-items-end" style="background-image: url(images/${list.img});">
                                </div>
                                <div class="text">
                                    <h2 class="mb-0"><a href="car-single.jsp">${list.carName}</a></h2>
                                    <div class="d-flex mb-3">
                                        <span class="cat">${list.manufacturer}</span>
<!--                                        <p class="price ml-auto">${list.pricePerDay}K <span>/day</span></p>-->
                                    </div>
                                    <div class="d-flex mb-3">
                                        <span class="cat">Price per day</span>
                                        <p class="price ml-auto">${list.pricePerDay}K <span>/day</span></p>
                                    </div>
                                    <div class="d-flex mb-3">
                                        <span class="cat">Price per Hour</span>
                                        <p class="price ml-auto">${list.pricePerHour}K <span>/hour</span></p>
                                    </div>
                                    <p class="d-flex mb-0 d-block"><a href="bookcar?cid=${list.idCar}" class="btn btn-primary py-2 mr-1">Book now</a> <a href="detail?cid=${list.idCar}" class="btn btn-secondary py-2 ml-1">Details</a></p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>         
                </div>
                <ul class="pagination">
                    <c:if test="${currentPage == 1}">
                        <li class="page-item">
                            <a class="page-link" href="#">First</a>
                        </li>
                    </c:if>
                    <c:if test="${currentPage > 1}">
                        <li class="page-item">
                            <a class="page-link" href="search?manufacturer=${manufacturer}&type=${type}&pricePerDay=${pricePerDay}&pricePerHour=${pricePerHour}&searchInput=${searchInput}&page=1">First</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="search?manufacturer=${manufacturer}&type=${type}&pricePerDay=${pricePerDay}&pricePerHour=${pricePerHour}&searchInput=${searchInput}&page=${currentPage - 1}">${currentPage-1}</a>
                        </li>
                    </c:if>
                    <li class="page-item active"><a class="page-link" href="search?manufacturer=${manufacturer}&type=${type}&pricePerDay=${pricePerDay}&pricePerHour=${pricePerHour}&searchInput=${searchInput}&page=${currentPage}">${currentPage}</a></li>

                    <c:if test="${currentPage < totalPages}">
                        <li class="page-item">
                            <a class="page-link" href="search?manufacturer=${manufacturer}&type=${type}&pricePerDay=${pricePerDay}&pricePerHour=${pricePerHour}&searchInput=${searchInput}&page=${currentPage + 1}">${currentPage + 1}</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="search?manufacturer=${manufacturer}&type=${type}&pricePerDay=${pricePerDay}&pricePerHour=${pricePerHour}&searchInput=${searchInput}&&page=${totalPages}">End</a>
                        </li>
                    </c:if>
                    <c:if test="${currentPage == totalPages}">
                        <li class="page-item">
                            <a class="page-link" href="#">End</a>
                        </li>
                    </c:if>
                </ul>
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
                    <div class="col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/star.png" alt="alt"/></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">Reputation Brand</h3>
                                <p>Customers can choose a specific location when receiving the car. Car will deliver the car to the location on time.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/car-icon.png" alt="alt"/></span></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">Material Facilities</h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="services services-2 w-100 text-center">
                            <div class="icon d-flex align-items-center justify-content-center"><img src="images/smiling.png" alt="alt"/></span></div>
                            <div class="text w-100">
                                <h3 class="heading mb-2">Dedicated Service</h3>
                                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
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
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

    </body>
</html>
