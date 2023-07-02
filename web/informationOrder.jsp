<%-- 
    Document   : informationOrder
    Created on : Jun 17, 2023, 10:44:41 PM
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
    </head>
    <body>
        <!-- SIDEBAR -->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">Admin Dashboard</span>
            </a>
            <ul class="side-menu top">
                <li>
                    <a href="admindashboard">
                        <i class='bx bxs-dashboard'></i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="cardashboard">
                        <i class="fa-solid fa-car-side fa-xs"></i>
                        <span class="text">Car Management</span>
                    </a>
                </li>
                <li>
                    <a href="userdashboard">
                        <i class='bx bxs-group'></i>
                        <span class="text">User Management</span>
                    </a>
                </li>
                <li>
                    <a href="staffdashboard">
                        <i class='bx bxs-group'></i>
                        <span class="text">Staff Management</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa-solid fa-money-bill-transfer fa-xs"></i>
                        <span class="text">Income Management</span>
                    </a>
                </li>
                <li class="active">
                    <a href="scheduledashboard">
                        <i class="fa-solid fa-calendar-days fa-xs"></i>
                        <span class="text">Rental Schedule Management</span>
                    </a>
                </li>
            </ul>
            <ul class="side-menu">
                <li>
                    <a href="logout" class="logout">
                        <i class='bx bxs-log-out-circle'></i>
                        <span class="text">Logout</span>
                    </a>
                </li>
            </ul>
        </section>
        <!-- SIDEBAR -->
        <!-- CONTENT -->
        <section id="content">
            <!-- NAVBAR -->
            <nav>
                <i class='bx bx-menu'></i>
                <a href="#" class="nav-link">Categories</a>
                <form action="#">
                    <div class="form-input">
                        <input type="search" placeholder="Search...">
                        <button type="submit" class="search-btn"><i class='bx bx-search'></i></button>
                    </div>
                </form>
                <input type="checkbox" id="switch-mode" hidden>
                <label for="switch-mode" class="switch-mode"></label>
                <a href="#" class="notification">
                    <i class='bx bxs-bell'></i>
                    <span class="num">8</span>
                </a>
                <a href="#" class="profile">
                    <i class="fa-solid fa-user"></i>
                </a>
            </nav>
            <!-- NAVBAR -->
            <!-- MAIN -->
            <main>
                <div class="head-title">
                    <div class="left">
                        <h1>Dashboard</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Dashboard</a>
                            </li>
                            <li><i class='bx bx-chevron-right'></i></li>
                            <li>
                                <a class="active" href="#">Information Order</a>
                            </li>
                        </ul>
                    </div>
                </div>   
            </main>
            <div class="container" style="margin-bottom: 50px">
                <div class="py-5 text-center">
                    <h2>Information Order</h2>
                </div>
                <div class="row g-5 d-flex justify-content-center">
                    <div class="col-md-8 col-lg-8">
                        <form class="border rounded" action="informationorder" method="POST" style="padding: 10px">
                            <div class="row g-3">
                                <div class="col-sm-6" hidden="">
                                    <label class="form-label">Id order</label>
                                    <input name="idOrder" type="text" class="form-control"value="${orderDetail.idOrder}">
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Customer Name</label>
                                    <input name="customerName" type="text" class="form-control"value="${account.name}"disabled>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Car name</label>
                                    <input name="carName" type="text" class="form-control"value="${car.carName}"disabled>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Type rent</label>
                                    <select name="typeRent" class="form-control form-control" disabled>
                                        <c:if test="${typeRentCar == 0}">
                                            <option value="day" selected>Rent by day</option>
                                            <option value="hour">Rent by hour</option>
                                        </c:if>
                                        <c:if test="${typeRentCar == 1}">
                                            <option value="day" >Rent by day</option>
                                            <option value="hour" selected>Rent by hour</option>
                                        </c:if>
                                    </select> 
                                </div>
                                <c:if test="${typeRentCar == 0}">
                                    <div class="col-sm-6">
                                        <label class="form-label">Number of day rent</label>
                                        <input name="numOfDayRent" type="text" class="form-control"value="${orderDetail.numDay}" disabled>
                                    </div>
                                </c:if>
                                <c:if test="${typeRentCar == 1}">
                                    <div class="col-sm-6">
                                        <label class="form-label">Number of hour rent</label>
                                        <input name="numOfDayRent" type="text" class="form-control"value="${orderDetail.numHour}" disabled>
                                    </div>
                                </c:if>
                                <c:if test="${typeRentCar == 0}">
                                    <div class="col-sm-6">
                                        <label class="form-label">From day</label>
                                        <input name="fromDay" class="form-control" type="date" value="${orderDetail.fromDay}" disabled>
                                    </div>
                                    <div class="col-sm-6">
                                        <label class="form-label">To day</label>
                                        <input name="toDay" class="form-control" type="date" value="${toDay}" disabled>                                    
                                    </div>
                                </c:if>
                                <c:if test="${typeRentCar == 1}">
                                    <div class="col-sm-6">
                                        <label class="form-label">From Hour</label>
                                        <input name="fromHour" class="form-control" type="datetime-local" value="${orderDetail.fromHour}" disabled>  
                                    </div>
                                    <div class="col-sm-6">
                                        <label class="form-label">To Hour</label>
                                        <input name="toHour" class="form-control" type="datetime-local" value="${toHour}"disabled>
                                    </div>
                                </c:if>

                                <div class="col-sm-4">
                                    <label class="form-label">Type pick up car</label>
                                    <select name="typePickupCar" class="form-control form-control" disabled>
                                        <c:if test="${typeReceiveCar == 0}">
                                            <option value="hour">Optional</option>
                                            <option value="day" selected>Fixed</option>
                                        </c:if>
                                        <c:if test="${typeReceiveCar == 1}">
                                            <option value="hour" selected>Optional</option>
                                            <option value="day">Fixed</option>
                                        </c:if>

                                    </select> 
                                </div>
                                <div class="col-sm-8">
                                    <label class="form-label">Location pick up car</label>
                                    <input name="locationPickup" type="text" class="form-control"value="${orderDetail.location}" disabled>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Method Payment</label>
                                    <select name="methodPay" class="form-control form-control" disabled>
                                        <c:if test="${methodPayCar == 0}">
                                            <option value="day" selected>Credit Payment</option>
                                            <option value="hour">Direct Payment</option>
                                        </c:if>
                                        <c:if test="${methodPayCar == 1}">
                                            <option value="day" >Credit Payment</option>
                                            <option value="hour" selected>Direct Payment</option>
                                        </c:if>
                                    </select> 
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Total Price</label>
                                    <input name="totalPrice" type="text" class="form-control"value="${orderDetail.totalPrice}"disabled>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Citizen identification</label>
                                    <div class="text-center">
                                        <img src="images/${account.imgCCCD}" 
                                             alt="img" height="160px" width="350px">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Car driving license</label>
                                    <div class="text-center">
                                        <img src="images/${account.imgLicense}" 
                                             alt="img" height="160px" width="350px">
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <label class="form-label">Car return date</label>
                                    <input name="dayReturn" type="datetime-local" class="form-control"value="">
                                </div>
                                <div class="col-sm-4">
                                    <label class="form-label">Status return car</label>
                                    <select name="isReturn" class="form-control form-control">
                                        <c:if test="${orderDetail.isReturn == 0}">
                                            <option value="0" selected>Unpaid car</option>
                                            <option value="1">Paid car</option>
                                        </c:if>
                                        <c:if test="${orderDetail.isReturn == 1}">
                                            <option value="0">Unpaid car</option>
                                            <option value="1" selected>Paid car</option>
                                        </c:if>
                                    </select> 
                                </div>
                                <div class="col-sm-4">
                                    <label class="form-label">Status order</label>
                                    <select name="status" class="form-control form-control">
                                        <option value="0">${orderDetail.status}</option>
                                        <option value="1">Order processing</option>
                                        <option value="2">Order successful</option>
                                        <option value="3">Order rejected</option>
                                        <option value="4">Order completion</option>
                                    </select> 
                                </div>

                            </div>
                            <hr>
                            <input type="submit" class="btn btn-primary" value="Save changes">
                        </form>
                    </div>

                </div>
                <div>
            </div>
            <script src="js/script.js"></script>
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
