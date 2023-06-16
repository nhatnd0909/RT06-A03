<%-- 
    Document   : bookCar
    Created on : Jun 13, 2023, 10:51:07 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
                        <p class="breadcrumbs"><span class="mr-2"><a href="home">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Book Car <i class="ion-ios-arrow-forward"></i></span></p>
                        <h1 class="mb-3 bread">Check Information</h1>
                    </div>
                </div>
            </div>
        </section>
        <div class="container">
            <div class="py-5 text-center">
                <h2>Checkout Information</h2>
            </div>
            <div class="row g-5 d-flex justify-content-center">
                <div class="row g-5">
                    <div class="col-md-5 col-lg-4 order-md-last">
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="text-primary">Rental Details</span>
                        </h4>
                        <ul class="list-group mb-3">
                            <div class="card" style="width: 20rem;">
                                <img class="card-img-top" src="images/${car.img}" alt="Card image cap">
                                <div class="card-body">
                                    <h4 class="card-title">${car.carName}</h4>
                                    <div class="clearfix" style="">
                                        <p class="float-left" style="color: black">Type</p>
                                        <p class="float-right" style="color: black"><span>${car.carType}</p>
                                    </div>
                                    <div class="clearfix" style="">
                                        <p class="float-left" style="color: black">Day rent:</p>
                                        <p class="float-right" style="color: black"><span>${car.pricePerDay}K</span>/ Day</p>
                                    </div>
                                    <div class="clearfix" style="">
                                        <p class="float-left" style="color: black">Hour rent:</p>
                                        <p class="float-right" style="color: black;"><span>${car.pricePerHour}K</span>/ Hour</p>
                                    </div>
                                    <div class="" style="margin-top: 10px">
                                        <p style="color: black;font-weight: bold">Rented Day</p>
                                        <div class="row">
                                            <div class="col-md-5">
                                                <p style="color: black">From:</p>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="color: black">To:</p>
                                            </div>
                                            <c:forEach items="${scheduleDay}" var="scheduleDay">
                                                <div class="col-md-5">
                                                    <p style="color: black">${scheduleDay.fromDay}</p>
                                                </div>
                                                <div class="col-md-6">
                                                    <p style="color: black">${scheduleDay.toDay}</p>
                                                </div>
                                            </c:forEach>

                                        </div>
                                        <p style="color: black ;font-weight: bold">Rented Hour:</p>
                                        <div class="row">
                                            <div class="col-md-5">
                                                <p style="color: black">From:</p>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="color: black">To:</p>
                                            </div>
                                            <c:forEach items="${scheduleHour}" var="scheduleHour">
                                                <div class="col-md-5">
                                                    <p style="color: black">${scheduleHour.fromHour}</p>
                                                </div>
                                                <div class="col-md-6">
                                                    <p style="color: black">${scheduleHour.toHour}</p>
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <p class="note text-danger" style="font-size: 11px"><i class="fa-light fa-triangle-exclamation" style="color: #ce5f5f;"></i>Car was busy during the above time. Please book another car or choose a suitable time</p>
                                    </div> 
                                </div>
                            </div>
                        </ul>
                    </div>
                    <div class="col-md-8 col-lg-8">
                        <form action="bookcar?cid=${car.idCar}" method="POST">
                            <div class="row g-3">
                                <div class="col-sm-12">
                                    <label class="form-label">Full name</label>
                                    <input name="name" type="text" class="form-control"value="${account.name}">
                                </div>
                                <div class="col-12">
                                    <label class="form-label">Email <span class="text-muted">(Optional)</span></label>
                                    <input name="email" type="email" class="form-control" value="${account.email}">
                                </div>
                                <div class="col-sm-12">
                                    <label class="form-label">Phone number</label>
                                    <input name="phone" type="text" class="form-control"value="${account.phone}">
                                </div>
                                <div class="col-12">
                                    <label for="address" class="form-label">Address</label>
                                    <input name="address" type="text" class="form-control" value="${add}">
                                </div>
                                <div class="col-md-4 form-group">
                                    <label for="country" class="form-label">Province/ City</label>
                                    <input name="city" type="text" class="form-control" value="${city}">    
                                </div>
                                <div class="col-md-4 form-group">
                                    <label for="state" class="form-label">District</label>
                                    <input name="district" type="text" class="form-control" value="${district}">   
                                </div>
                                <div class="col-md-4 form-group">
                                    <label class="form-label">Wards</label>
                                    <input name="wards" type="text" class="form-control" value="${wards}">  
                                </div>
                                <div class="col-md-6 form-group">
                                    <label class="form-label">Rental type</label>
                                    <select name="typeRent" class="form-control form-control-lg">
                                        <option value="day">Rent by day</option>
                                        <option value="hour">Rent by hour</option>
                                    </select> 
                                </div>
                                <div class="col-md-6 form-group">
                                    <label class="form-label">Pick up location</label>
                                    <select name="position" class="form-control form-control-lg">
                                        <option value="elective">Elective position</option>
                                        <option value="fixed">Fixed position</option>
                                    </select> 
                                </div>
                                <div class="col-12">
                                    <label class="form-label">Citizen Identification</label>
                                    <div class="custom-file">
                                        <input name="ci" type="file" class="custom-file-input">
                                        <label class="custom-file-label">Choose file...</label>

                                    </div>
                                </div>
                                <div class="col-12">
                                    <label for="address" class="form-label">Driving License</label>
                                    <div class="custom-file">
                                        <input name="dl" type="file" class="custom-file-input">
                                        <label class="custom-file-label">Choose file...</label>
                                    </div>
                                </div>
                            </div>
                            <hr class="my-4">
                            <button class="w-100 btn btn-danger btn-lg" type="submit" style="margin-bottom: 50px">Continue to checkout</button>
                        </form>
                    </div>

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

