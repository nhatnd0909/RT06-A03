<%-- 
    Document   : informationCar
    Created on : Jun 10, 2023, 9:53:01 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

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
                <li class="active">
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
                <li>
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
                                <a class="active" href="#">Information Car</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="container">
                    <div class="py-5 text-center">
                        <h2>Information Car</h2>
                    </div>
                    <div class="row g-5 d-flex justify-content-center">
                        <div class="col-md-8 col-lg-8">
                            <c:forEach items="${car}" var="car">
                                <form class="border rounded" action="informationcar" method="POST" style="padding: 10px">
                                    <div class="row g-3">
                                        <div class="col-sm-6">
                                            <label class="form-label">Car ID</label>
                                            <input class="form-control" type="text" name="id" value="${car.idCar}">
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Car Name</label>
                                            <input class="form-control" type="text" name="name" value="${car.carName}">
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Type Car</label>
                                            <select class="form-control" name="type">
                                                <option value="${car.carType}">${car.carType}</option>
                                                <c:forEach items="${listType}" var="listType">
                                                    <option value="${listType}">${listType}</option>
                                                </c:forEach> 
                                            </select>
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Manufacturer</label>
                                            <select class="form-control" name="manufactory">
                                                <option value="${car.manufacturer}">${car.manufacturer}</option>
                                                <c:forEach items="${listManufactory}" var="listManufactory">
                                                    <option value="${listManufactory}">${listManufactory}</option>
                                                </c:forEach> 
                                            </select>
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Type Fuel</label>
                                            <select class="form-control" name="fuel">
                                                <option value="${car.typeFuel}">${car.typeFuel}</option>
                                                <option value="Petrol">Petrol</option>
                                                <option value="Gasoline">Gasoline</option>
                                            </select>
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Car Color</label>
                                            <input class="form-control" type="text" name="color"color" value="${car.color}">
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Number of Seat</label>
                                            <input class="form-control" type="text" name="seat" value="${car.numberOfSeat}">
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Car Status</label>
                                            <select class="form-control" name="status">
                                                <option value="${car.status}">${car.status}</option>
                                                <option value="Free">Free</option>
                                                <option value="Rented">Rented</option>
                                            </select>
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Car Description</label>
                                            <input class="form-control" type="text" name="description" value="${car.description}">
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Year of manufacture</label>
                                            <input class="form-control" type="text" name="year" value="${car.yearOfManufacture}">
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Img Car</label>
                                            <input class="form-control" type="text" name="img" value="${car.img}">
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Price per Day</label>
                                            <input class="form-control" type="text" name="pricePerDay" value="${car.pricePerDay}">
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="form-label">Price per Hour</label>
                                            <input class="form-control" type="text" name="pricePerHour" value="${car.pricePerHour}">
                                        </div>
                                    </div>
                                    
                                        <input type="submit" class="btn btn-primary" value="Save changes" style="margin-top: 20px">
                                </form>
                            </c:forEach>

                        </div>
                    </div>
                </div>





                <div class="container">
                    <c:forEach items="${car}" var="car">
<!--                        <form action="informationcar" method="POST">
                            <div>
                                <div class="">
                                    <div class="">
                                        <div class="">
                                            <h5 class="modal-title" id="">Information Car</h5>
                                        </div>
                                        <div class="">
                                            <table class="table">
                                                <tr>
                                                    <td>
                                                        Car ID
                                                    </td>
                                                    <td>
                                                        <input type="text" name="id" value="${car.idCar}">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Car Name
                                                    </td>
                                                    <td>
                                                        <input type="text" name="name" value="${car.carName}">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Car Type
                                                    </td>
                                                    <td>
                                                        <select class="form-control" name="type" style="max-width: 40%">
                                                            <option value="${car.carType}">${car.carType}</option>
                                                            <c:forEach items="${listType}" var="listType">
                                                                <option value="${listType}">${listType}</option>
                                                            </c:forEach> 
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Manufacturer
                                                    </td>
                                                    <td>
                                                        <select class="form-control" name="manufactory" style="max-width: 40%">
                                                            <option value="${car.manufacturer}">${car.manufacturer}</option>
                                                            <c:forEach items="${listManufactory}" var="listManufactory">
                                                                <option value="${listManufactory}">${listManufactory}</option>
                                                            </c:forEach> 
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Fuel
                                                    </td>
                                                    <td>
                                                        <select class="form-control" name="fuel" style="max-width: 40%">
                                                            <option value="${car.typeFuel}">${car.typeFuel}</option>
                                                            <option value="Petrol">Petrol</option>
                                                            <option value="Gasoline">Gasoline</option>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Car Color
                                                    </td>
                                                    <td>
                                                        <input type="text" name="color"color" value="${car.color}">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Number of Seat
                                                    </td>
                                                    <td>
                                                        <input type="text" name="seat" value="${car.numberOfSeat}">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Car Status
                                                    </td>
                                                    <td>
                                                        <select class="form-control" name="status" style="max-width: 40%">
                                                            <option value="${car.status}">${car.status}</option>
                                                            <option value="Free">Free</option>
                                                            <option value="Rented">Rented</option>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Car Description
                                                    </td>
                                                    <td>
                                                        <input type="text" name="description" value="${car.description}">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Year of manufacture 
                                                    </td>
                                                    <td>
                                                        <input type="text" name="year" value="${car.yearOfManufacture}">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Car IMG
                                                    </td>
                                                    <td>
                                                        <input type="text" name="img" value="${car.img}">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Price per Day
                                                    </td>
                                                    <td>
                                                        <input type="text" name="pricePerDay" value="${car.pricePerDay}">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Price per Hour
                                                    </td>
                                                    <td>
                                                        <input type="text" name="pricePerHour" value="${car.pricePerHour}">
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <input type="submit" class="btn btn-primary" value="Save changes">
                                    </div>
                                </div>
                            </div>
                        </form>-->
                    </c:forEach>

                    <div>
                        <div class="d-flex justify-content-center" style="margin-top: 50px">
                            <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal">
                                Delete Car
                            </button>
                        </div>

<!--                        <form action="deleteStaff?sid=${staff.id}" method="Post">-->
                        <form action="deletecar?cid=${carId}" method="Post">
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Delete Car</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure you want to delete this Car information?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <!--                                    <button type="button" class="btn btn-danger">Delete</button>-->
                                            <input type="submit" class="btn btn-danger" value="Delete">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>                        
                </div>


            </main>

            <!-- MAIN -->
        </section>
        <!-- CONTENT -->
        <form action="addcar" method="POST">
            <div class="modal fade bd-example-modal-lg" id="car" tabindex="-1" role="dialog"
                 aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Add New Car</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        Car ID
                                    </td>
                                    <td>
                                        <input type="text" name="id" placeholder="Car ID">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Car Name
                                    </td>
                                    <td>
                                        <input type="text" name="name" placeholder="Car Name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Car Type
                                    </td>
                                    <td>
                                        <select class="form-control" name="type" style="max-width: 40%">
                                            <c:forEach items="${listType}" var="listType">
                                                <option value="${listType}">${listType}</option>
                                            </c:forEach> 
                                        </select>
                                    </td>

                                </tr>
                                <tr>
                                    <td>
                                        Manufacturer
                                    </td>
                                    <td>
                                        <select class="form-control" name="manufactory" style="max-width: 40%">
                                            <c:forEach items="${listManufactory}" var="listManufactory">
                                                <option value="${listManufactory}">${listManufactory}</option>
                                            </c:forEach> 
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Fuel
                                    </td>
                                    <td>
                                        <select class="form-control" name="fuel" style="max-width: 40%">
                                            <option value="Petrol">Petrol</option>
                                            <option value="Gasoline">Gasoline</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Car Color
                                    </td>
                                    <td>
                                        <input type="text" name="color"color" placeholder="Car Color">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Number of Seat
                                    </td>
                                    <td>
                                        <input type="text" name="seat" placeholder="Number of Seat">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Year of manufacture 
                                    </td>
                                    <td>
                                        <input type="text" name="year" placeholder="Year of manufacture ">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Car IMG
                                    </td>
                                    <td>
                                        <input type="text" name="img" placeholder="Car IMG">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Price per Day
                                    </td>
                                    <td>
                                        <input type="text" name="pricePerDay" placeholder="Price per Day">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Price per Hour
                                    </td>
                                    <td>
                                        <input type="text" name="pricePerHour" placeholder="Price per Hour">
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button class="btn btn-primary">Add</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <script src="js/script.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>
