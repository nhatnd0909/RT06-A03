<%-- 
    Document   : car-single.jsp
    Created on : May 25, 2023, 11:01:56 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Detail Car</title>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
                        <!--	          <li class="nav-item"><a href="services" class="nav-link">Services</a></li>-->
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
                        <p class="breadcrumbs"><span class="mr-2"><a href="home.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Car details <i class="ion-ios-arrow-forward"></i></span></p>
                        <h1 class="mb-3 bread">Car Details</h1>
                    </div>
                </div>
            </div>
        </section>


        <section class="ftco-section ftco-car-details">
            <div class="container">
                <c:forEach items="${list}" var="list">
                    <div class="row justify-content-center">
                        <div class="col-md-12">
                            <div class="car-details">
                                <div class="img rounded" style="background-image: url(images/${list.img});"></div>
                                <div class="text text-center">
                                    <span class="subheading">${list.manufacturer}</span>
                                    <h3 style="font-weight: bold">${list.carName}</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="row">
                    <div class="col-md-9">
                        <h4>General Features</h4>
                        <c:forEach items="${list}" var="list">
                            <div class="row">
                                <div class="col-md d-flex align-self-stretch ftco-animate">
                                    <div class="media block-6 services">
                                        <div class="media-body py-md-4">
                                            <div class="d-flex mb-3 align-items-center">
                                                <div class="icon d-flex align-items-center justify-content-center"><span class="flaticon-car-seat"></span></div>
                                                <div class="text">
                                                    <h3 class="heading mb-0 pl-3">
                                                        Seats
                                                        <span>${list.numberOfSeat} Adults</span>
                                                    </h3>
                                                </div>
                                            </div>
                                        </div>
                                    </div>      
                                </div>
                                <div class="col-md d-flex align-self-stretch ftco-animate">
                                    <div class="media block-6 services">
                                        <div class="media-body py-md-4">
                                            <div class="d-flex mb-3 align-items-center">
                                                <div class="icon d-flex align-items-center justify-content-center"><span class="flaticon-pistons"></span></div>
                                                <div class="text">
                                                    <h3 class="heading mb-0 pl-3">
                                                        Manufacturer
                                                        <span>${list.manufacturer}</span>
                                                    </h3>
                                                </div>
                                            </div>
                                        </div>
                                    </div>      
                                </div>
                                <div class="col-md d-flex align-self-stretch ftco-animate">
                                    <div class="media block-6 services">
                                        <div class="media-body py-md-4">
                                            <div class="d-flex mb-3 align-items-center">
                                                <div class="icon d-flex align-items-center justify-content-center"><span class="flaticon-diesel"></span></div>
                                                <div class="text">
                                                    <h3 class="heading mb-0 pl-3">
                                                        Fuel
                                                        <span>${list.typeFuel}</span>
                                                    </h3>
                                                </div>
                                            </div>
                                        </div>
                                    </div>      
                                </div>
                                <div class="col-md d-flex align-self-stretch ftco-animate">
                                    <div class="media block-6 services">
                                        <div class="media-body py-md-4">
                                            <div class="d-flex mb-3 align-items-center">
                                                <div class="icon d-flex align-items-center justify-content-center"><span class="flaticon-car"></span></div>
                                                <div class="text">
                                                    <h3 class="heading mb-0 pl-3">
                                                        Type
                                                        <span>${list.carType}</span>
                                                    </h3>
                                                </div>
                                            </div>
                                        </div>
                                    </div>      
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 pills">
                                    <div class="bd-example bd-example-tabs">
                                        <div class="d-flex justify-content-center">
                                            <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">

                                                <li class="nav-item">
                                                    <a class="nav-link active" id="pills-description-tab" data-toggle="pill" href="#pills-description" role="tab" aria-controls="pills-description" aria-expanded="true">Features</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" id="pills-manufacturer-tab" data-toggle="pill" href="#pills-manufacturer" role="tab" aria-controls="pills-manufacturer" aria-expanded="true">Description</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" id="pills-review-tab" data-toggle="pill" href="#pills-review" role="tab" aria-controls="pills-review" aria-expanded="true">Review</a>
                                                </li>
                                            </ul>
                                        </div>

                                        <div class="tab-content" id="pills-tabContent">
                                            <div class="tab-pane fade show active" id="pills-description" role="tabpanel" aria-labelledby="pills-description-tab">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <ul class="features">
                                                            <li class="check"><span class="ion-ios-checkmark"></span>Airconditions</li>
                                                            <li class="check"><span class="ion-ios-checkmark"></span>GPS</li>
                                                            <li class="check"><span class="ion-ios-checkmark"></span>Luggage</li>
                                                        </ul>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <ul class="features">
                                                            <li class="check"><span class="ion-ios-checkmark"></span>Seat Belt</li>
                                                            <li class="check"><span class="ion-ios-checkmark"></span>Water</li>
                                                            <li class="check"><span class="ion-ios-checkmark"></span>Bluetooth</li>
                                                        </ul>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <ul class="features">
                                                            <li class="check"><span class="ion-ios-checkmark"></span>Audio input</li>
                                                            <li class="check"><span class="ion-ios-checkmark"></span>Car Kit</li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="tab-pane fade" id="pills-manufacturer" role="tabpanel" aria-labelledby="pills-manufacturer-tab">
                                                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</p>
                                                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane. Pityful a rethoric question ran over her cheek, then she continued her way.</p>
                                            </div>

                                            <div class="tab-pane fade" id="pills-review" role="tabpanel" aria-labelledby="pills-review-tab">
                                                <div class="row">
                                                    <div class="col-md-7">
                                                        <h3 class="head">23 Reviews</h3>
                                                        <div class="review d-flex">
                                                            <div class="user-img" style="background-image: url(images/person_1.jpg)"></div>
                                                            <div class="desc">
                                                                <h4>
                                                                    <span class="text-left">Jacob Webb</span>
                                                                    <span class="text-right">14 March 2018</span>
                                                                </h4>
                                                                <p class="star">
                                                                    <span>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                    </span>
                                                                    <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                                                </p>
                                                                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                                                            </div>
                                                        </div>
                                                        <div class="review d-flex">
                                                            <div class="user-img" style="background-image: url(images/person_2.jpg)"></div>
                                                            <div class="desc">
                                                                <h4>
                                                                    <span class="text-left">Jacob Webb</span>
                                                                    <span class="text-right">14 March 2018</span>
                                                                </h4>
                                                                <p class="star">
                                                                    <span>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                    </span>
                                                                    <span class="text-right"><a href="#" class="reply"><i class="icon-reply"></i></a></span>
                                                                </p>
                                                                <p>When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrov</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <div class="rating-wrap">
                                                            <h3 class="head">Give a Review</h3>
                                                            <div class="wrap">
                                                                <p class="star">
                                                                    <span>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        (98%)
                                                                    </span>
                                                                    <span>20 Reviews</span>
                                                                </p>
                                                                <p class="star">
                                                                    <span>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        (85%)
                                                                    </span>
                                                                    <span>10 Reviews</span>
                                                                </p>
                                                                <p class="star">
                                                                    <span>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        (70%)
                                                                    </span>
                                                                    <span>5 Reviews</span>
                                                                </p>
                                                                <p class="star">
                                                                    <span>
                                                                        <i class="ion-ios-star"></i>
                                                                        <i class="ion-ios-star"></i>
                                                                        (10%)
                                                                    </span>
                                                                    <span>0 Reviews</span>
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="margin-top: 50px">        
                                <div class="" style="width: 100%">
                                    <h4>Car Rental Procedure</h4>
                                    <div class="card" style="background-color: #fef7f4;border-radius: 10px">
                                        <div class="row">
                                            <div class="col-md-5" style="margin-left: 20px">
                                                <p class="note text-danger" style="font-size: 13px"><img src="images/info.png" alt="alt"/>Mandatory</p>
                                                <p style="color: black"><img src="images/id-card.png" alt="alt"/>CMND and GPLX</p>
                                            </div>
                                            <div class="col-md-5">
                                                <p class="" style="font-size: 13px"><img src="images/info.png" alt="alt"/>Choose 1 of 2 forms</p>
                                                <p style="color: black"><img src="images/passport.png" alt="alt"/>Passport</p>
                                                <p style="color: black"><img src="images/idcard .png" alt="alt"/>CCCD with chip</p>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="margin-top: 50px">        
                                <div class="" style="width: 100%">
                                    <h4>Collateral</h4>
                                    <div class="card" style="background-color: #fef7f4;border-radius: 10px">
                                        <div class="">
                                            <p style="color: black; margin-left: 20px">15 million (cash/transfer to the car owner when receiving the car) or Motorcycle (with original tie) worth 15 million</p>
                                        </div> 
                                    </div>
                                </div>
                            </div>  
                            <div class="row" style="margin-top: 50px">        
                                <div class="" style="width: 100%">
                                    <h4>Rules</h4>
                                    <p>Other rule:</p>
                                    <ul>
                                        <li>Use the vehicle for the right purpose.</li>
                                        <li>Do not use the rental car for illegal or illegal purposes.</li>
                                        <li>Do not use rental cars for pledge or mortgage.</li>
                                        <li>No smoking, chewing gum, or littering in the vehicle.</li>
                                        <li>Do not carry flammable and explosive national goods.</li>
                                    </ul>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col-md-3">
                        <c:forEach items="${list}" var="list">
                            <div class="card" style="width: 18rem; border-radius:5%; background-color: #f7fbff">
                                <div class="card-body">
                                    <h3 class="card-title d-flex justify-content-center"><span class="text-primary">Rental Details</span></h3>
                                    <div>
                                        <div class="card clearfix" style="">
                                            <div class="" style="color: black;margin: 5px;font-size: 15px">
                                                <p class="float-left text-danger">Car rental schedule:</p>
                                            </div>
                                            <div class="" style="color: black;margin: 5px;font-size: 15px">
                                                    <p class="float-left">From:</p>
                                                    <p class="float-left" style="margin-left: 105px">To:</p>
                                                </div>
                                            <c:forEach items="${scheduleDay}" var="scheduleDay">
                                                <div class="" style="color: black;margin: 5px;font-size: 13px">
                                                    <p class="float-left">${scheduleDay.fromDay}</p>
                                                    <p class="float-right">${scheduleDay.toDay}</p>
                                                </div>
                                            </c:forEach>
                                            <c:forEach items="${scheduleHour}" var="scheduleHour">
                                                <div class="" style="color: black;margin: 5px;font-size: 13px">
                                                    <p class="float-left">${scheduleHour.fromHour}</p>
                                                    <p class="float-right">${scheduleHour.toHour}</p>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <p class="note text-danger" style="font-size: 11px"><i class="fa-light fa-triangle-exclamation" style="color: #ce5f5f;"></i>Car was busy during the above time. Please book another car or choose a suitable time</p>
                                        <div class="card">
                                            <div style="margin: 5px">
                                                <p class="" style="font-size: 13px">Pick-up location</p>
                                                <p class="" style="color: black">Hải Châu - Đà Nẵng</p>
                                                <p style="font-size: 11px">Car owners are supported to deliver the car to the place. Specific address will be displayed after deposit</p>
                                            </div>
                                        </div>
                                        <div class="clearfix" style="">
                                            <p class="float-left" style="color: black">Day rent:</p>
                                            <p class="float-right" style="color: black"><span>${list.pricePerDay}K</span>/ Day</p>
                                        </div>

                                        <div class="clearfix" style="">
                                            <p class="float-left" style="color: black">Hour rent:</p>
                                            <p class="float-right" style="color: black;"><span>${list.pricePerHour}K</span>/ Hour</p>
                                        </div>
                                    </div>  
                                    <a href="bookcar?cid=${list.idCar}"><button type="button" class="btn btn-primary btn-lg btn-block">Book Car</button></a>
                                </div>        
                            </div>
                        </c:forEach>

                    </div>
                </div>

            </div>
        </section>
        <section class="ftco-section ftco-no-pt">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-12 heading-section text-center ftco-animate mb-5">
                        <span class="subheading">Choose Car</span>
                        <h2 class="mb-2">Related Cars</h2>
                    </div>
                </div>
                <div class="row d-flex justify-content-center">
                    <c:forEach items="${listCarRelated}" var="listCarRelated">
                        <div class="col-md-4">
                            <div class="car-wrap rounded ftco-animate">
                                <div class="img rounded d-flex align-items-end" style="background-image: url(images/${listCarRelated.img});">
                                </div>
                                <div class="text">
                                    <h2 class="mb-0"><a href="car-single.html">${listCarRelated.carName}</a></h2>
                                    <div class="d-flex mb-3">
                                        <span class="cat">${listCarRelated.manufacturer}</span>
                                        <p class="price ml-auto">${listCarRelated.pricePerDay}K <span>/day</span></p>
                                    </div>
                                    <p class="d-flex mb-0 d-block"><a href="#" class="btn btn-primary py-2 mr-1">Book now</a> <a href="detail?cid=${listCarRelated.idCar}" class="btn btn-secondary py-2 ml-1">Details</a></p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
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
    </body>
</html>
