<%-- 
    Document   : informationHistoryBooking
    Created on : Jun 18, 2023, 9:40:42 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Boxicons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- My CSS -->
        <link rel="stylesheet" href="css/css/index.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Admin Dashboard</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="home"><img /> Car<span>Book</span></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item"><a href="home" class="nav-link">Home</a></li>
                        <li class="nav-item"><a href="about" class="nav-link">About</a></li>
                        <!--                        <li class="nav-item"><a href="services" class="nav-link">Services</a></li>-->
                        <li class="nav-item"><a href="pricing" class="nav-link">Pricing</a></li>
                        <li class="nav-item "><a href="car" class="nav-link">Cars</a></li>
                        <li class="nav-item"><a href="contact" class="nav-link">Contact</a></li>
                            <c:if test="${sessionScope.id != null}">
                            <li class="nav-item active"><a href="profile?id=${sessionScope.id}" class="nav-link">Profile</a></li> 
                            <li class="nav-item"><a href="logout" class="nav-link">Logout</a></li>
                            </c:if>
                            <c:if test="${sessionScope.id == null}">
                            <li class="nav-item"><a href="login" class="nav-link">Login</a></li>
                            </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        <section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('images/banner.jpg');" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
                    <div class="col-md-9 ftco-animate pb-5">
                        <p class="breadcrumbs"><span class="mr-2"><a href="home">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Profile <i class="ion-ios-arrow-forward"></i></span></p>
                        <h1 class="mb-3 bread">History BooKing</h1>
                    </div>
                </div>
            </div>
        </section>
        <div class="container">
            <div class="py-5 text-center">
                <h2>Information Detail Order</h2>
            </div>
            <div class="row g-5 d-flex justify-content-center">
                <div class="col-md-10 col-lg-10">
                    <form class="border rounded" action="userchangebooking" method="GET" style="padding: 10px">
                        <div class="row g-3">
                            <div class="col-sm-6" hidden="">
                                <label class="form-label">Id order</label>
                                <input class="form-control" type="text" name="idOrder" value="${orderDetail.idOrder}">
                            </div>
                            <div class="col-sm-12">
                                <label class="form-label">Car Name</label>
                                <input class="form-control" type="text" name="carName" value="${car.carName}" disabled>
                            </div>
                            <div class="col-sm-6">
                                <label class="form-label">Type rent</label>
                                <select class="form-control" name="typeRent" disabled>
                                    <c:if test="${typeRentCar == 0}">
                                        <option value="day" selected>Day</option>
                                        <option value="hour">Hour</option>
                                    </c:if>
                                    <c:if test="${typeRentCar == 1}">
                                        <option value="day" selected>Hour</option>
                                        <option value="hour">Day</option>
                                    </c:if>
                                </select>
                            </div>
                            <div class="col-sm-6">
                                <label class="form-label">Type recieve car</label>
                                <select class="form-control" name="typeRecieve">
                                    <c:if test="${typeReceiveCar == 0}">
                                        <option value="fixed" selected>Fixed</option>
                                        <option value="elective">Optional</option>
                                    </c:if>
                                    <c:if test="${typeReceiveCar == 1}">
                                        <option value="fixed">Fixed</option>
                                        <option value="elective" selected>Optional</option>
                                    </c:if>
                                </select>
                            </div>

                            <div class="col-sm-4">
                                <c:if test="${typeRentCar == 0}">
                                    <label class="form-label">Rent day</label>
                                    <input class="form-control" type="date" name="fromday"color" value="${orderDetail.fromDay}" disabled="">
                                </c:if>
                                <c:if test="${typeRentCar == 1}">
                                    <label class="form-label">Rent hour</label>
                                    <input class="form-control" type="datetime-local" name="fromHour"color" value="${orderDetail.fromHour}" disabled="">
                                </c:if>
                            </div>
                            <div class="col-sm-4">
                                <c:if test="${typeRentCar == 0}">
                                    <label class="form-label">Number day rent</label>
                                    <input class="form-control" type="text" name="numDay" value="${orderDetail.numDay}">
                                </c:if>
                                <c:if test="${typeRentCar == 1}">
                                    <label class="form-label">Number hour rent</label>
                                    <input class="form-control" type="text" name="numHour" value="${orderDetail.numHour}">
                                </c:if> 
                            </div>
                            <div class="col-sm-4">
                                <c:if test="${typeRentCar == 0}">
                                    <label class="form-label">Return day</label>
                                    <input class="form-control" type="date" name="toDay" value="${returnDay}" disabled>
                                </c:if>
                                <c:if test="${typeRentCar == 1}">
                                    <label class="form-label">Return hour</label>
                                    <input class="form-control" type="datetime-local" name="toDay" value="${returnHour}" disabled>
                                </c:if>
                            </div>
                            <div class="col-sm-12">
                                <label class="form-label">Car pick up location</label>
                                <!--<input class="form-control" type="text" name="location" value="${orderDetail.location}">-->
                            </div>
                            <c:if test="${typeReceiveCar == 0}">
                                <div class="col-sm-12">
                                    <label class="form-label">Address</label>
                                    <input name="address" type="text" class="form-control" value="${add}" >
                                </div>
                                <div class="col-sm-4">
                                    <label class="form-label">Province/ City</label>
                                    <input name="city" type="text" class="form-control" value="${city}" >
                                </div>
                                <div class="col-sm-4">
                                    <label class="form-label">District</label>
                                    <input name="district" type="text" class="form-control" value="${district}">
                                </div>
                                <div class="col-sm-4">
                                    <label class="form-label">Wards</label>
                                    <input name="wards" type="text" class="form-control" value="${wards}"> 
                                </div>
                            </c:if>
                            <c:if test="${typeReceiveCar == 1}">
                                <div class="col-sm-12">
                                    <label class="form-label">Address</label>
                                    <input name="address" type="text" class="form-control" value="${add}" >
                                </div>
                                <div class="col-sm-4">
                                    <label class="form-label">Province/ City</label>
                                    <input name="city" type="text" class="form-control" value="${city}" >
                                </div>
                                <div class="col-sm-4">
                                    <label class="form-label">District</label>
                                    <input name="district" type="text" class="form-control" value="${district}" >
                                </div>
                                <div class="col-sm-4">
                                    <label class="form-label">Wards</label>
                                    <input name="wards" type="text" class="form-control" value="${wards}" > 
                                </div>
                            </c:if>

                            <div class="col-sm-6">
                                <label class="form-label">Method payment</label>
                                <select class="form-control" name="methodPay">
                                    <c:if test="${methodPayCar == 0}">
                                        <option value="credit" selected>Credit payment</option>
                                        <option value="direct">Direct Payment</option>
                                    </c:if>
                                    <c:if test="${methodPayCar == 1}">
                                        <option value="credit">Credit payment</option>
                                        <option value="direct" selected>Direct Payment</option>
                                    </c:if>
                                </select>
                            </div>
                            <div class="col-sm-6">
                                <label class="form-label">Total price</label>
                                <input class="form-control" type="text" name="price" value="${orderDetail.totalPrice}" disabled>
                            </div>
                            <div class="col-sm-6">
                                <label class="form-label">Status</label>
                                <input class="form-control" type="text" name="status" value="${orderDetail.status}" disabled>
                            </div>
                            <c:if test="${flag == 0}">
                                <div class="col-sm-12" style="margin-top: 20px">
                                    <h6 class="text-danger">${notification}</h6>
                                </div>
                            </c:if>

                        </div>

                        <c:if test="${flag == 1}">
                            <input type="submit" class="btn btn-primary" value="Save changes" style="margin-top: 20px">
                        </c:if> 
                        <c:if test="${flag == 0}">
                            <input type="submit" class="btn btn-primary" value="Save changes" style="margin-top: 20px" disabled>
                        </c:if>       
                    </form>
                </div>

            </div>
            <div>
                <div class="d-flex justify-content-center" style="margin-top: 50px;margin-bottom: 50px">
                    <c:if test="${flag == 1}">
                        <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal">
                            Cancer Order
                        </button>
                    </c:if>  
                    <c:if test="${flag == 0}">
                        <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal" disabled>
                            Cancer Order
                        </button>
                    </c:if>
                </div>
                <form action="cancelorder" method="GET">
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Cancer Order</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Are you sure you want to cancer this order?
                                </div>
                                <div class="col-sm-6">
                                    <input class="form-control" type="hidden" name="idOrder" value="${orderDetail.idOrder}">
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" class="btn btn-danger" value="Cancel">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>  
        </div>




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

        <script src="js/script.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
