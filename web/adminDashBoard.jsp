<%-- 
    Document   : adminDashBoard
    Created on : May 29, 2023, 9:14:18 PM
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
    </head>

    <body>


        <!-- SIDEBAR -->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">Admin Dashboard</span>
            </a>
            <ul class="side-menu top">
                <li class="active">
                    <a href="#">
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
                <li>
                    <a href="scheduledashboard">
                        <i class="fa-solid fa-calendar-days fa-xs"></i>
                        <span class="text">Rental Schedule Management</span>
                    </a>
                </li>
                <li class="">
                    <a href="feedbackadmin">
                        <i class="fa-solid fa-calendar-days fa-xs"></i>
                        <span class="text">Feedback</span>
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
                    <span class="num">!</span>
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
                                <a class="active" href="#">Home</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check'></i>
                        <span class="text">
                            <h3>${totalCar}</h3>
                            <p>Car</p>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group'></i>
                        <span class="text">
                            <h3>${totalUser}</h3>
                            <p>User</p>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle'></i>
                        <span class="text">
                            <h3>$2543</h3>
                            <p>Total Income</p>
                        </span>
                    </li>
                </ul>
                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>User</h3>
                            <a href="userdashboard"><i class='bx bx-filter'></i></a>
                        </div>
                        <table>

                            <thead>
                                <tr>
                                    <th>UserName</th>
                                    <th>Name</th>
                                    <th>Day Of Birth</th>
                                    <th>Gender</th>
                                    <th>Phone</th>
                                    <th>Address</th>
                                </tr>
                            </thead>
                            <c:forEach items="${listUser}" var="list">
                                <tbody>
                                    <tr>
                                        <td>${list.userName}</td>
                                        <td>${list.name}</td>
                                        <td>${list.DOB}</td>
                                        <td>${list.gender}</td>
                                        <td>${list.phone}</td>
                                        <td>${list.address}</td>
                                    </tr>
                                </tbody>
                            </c:forEach>        
                        </table>
                    </div>
                </div>   
                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>Car Infomation</h3>
                            <a href="cardashboard"><i class='bx bx-filter'></i></a>
                        </div>
                        <table>

                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Type</th>
                                    <th>Manufactor</th>
                                    <th>Type Fuel</th>
                                    <th>Status</th>
                                    <th>Year</th>
                                    <th>Price Per Day</th>
                                    <th>Price Per Month</th>
                                </tr>
                            </thead>
                            <c:forEach items="${listCar}" var="list">
                                <tbody>
                                    <tr>
                                        <td>${list.carName}</td>
                                        <td>${list.carType}</td>
                                        <td>${list.manufacturer}</td>
                                        <td>${list.typeFuel}</td>
                                        <td>${list.status}</td>
                                        <td>${list.yearOfManufacture}</td>
                                        <td>${list.pricePerDay}</td>
                                        <td>${list.pricePerHour}</td>
                                    </tr>
                                </tbody>
                            </c:forEach>        
                        </table>
                    </div>
                </div> 
            </main>
            <!-- MAIN -->
        </section>
        <!-- CONTENT -->


        <script src="js/script.js"></script>
    </body>

</html>