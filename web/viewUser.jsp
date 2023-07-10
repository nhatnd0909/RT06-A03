<%-- 
    Document   : viewUser
    Created on : Jun 10, 2023, 12:25:39 AM
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
                <li>
                    <a href="cardashboard">
                        <i class="fa-solid fa-car-side fa-xs"></i>
                        <span class="text">Car Management</span>
                    </a>
                </li>
                <li class="active">
                    <a href="userdashboard">
                        <i class='bx bxs-group'></i>
                        <span class="text">User Management</span>
                    </a>
                </li>
                <li >
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
                    <a href="#">
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
                                <a class="active" href="#">Information User</a>
                            </li>
                        </ul>
                    </div>
                </div>   
            </main>

            <div class="container">
                <div class="py-5 text-center">
                    <h2>Information User</h2>
                </div>
                <div class="row g-5 d-flex justify-content-center">
                    <div class="col-md-8 col-lg-8">
                        <form class="border rounded" action="" method="" style="padding: 10px">
                            <div class="row g-3">
                                <div class="col-sm-6">
                                    <label class="form-label">Name user</label>
                                    <input class="form-control" type="text" name="name" value="${account.name}" disabled="">
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Citizen Identification</label>
                                    <input class="form-control" type="text" name="name" value="${account.CCCD}" disabled>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Day of Birth</label>
                                    <input class="form-control" type="date" name="dob" value="${account.DOB}" disabled>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Gender</label>
                                    <select class="form-control" name="gender" disabled>
                                        <c:if test="${test == 0}">
                                            <option value="Male" selected="">Male</option>
                                            <option value="Female">Female</option>
                                        </c:if>
                                        <c:if test="${test == 1}">
                                            <option value="Male" >Male</option>
                                            <option value="Female" selected="">Female</option>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Phone number</label>
                                    <input class="form-control" type="text" name="phone" value="${account.phone}" disabled>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Address</label>
                                    <input class="form-control" type="text" name="address" value="${account.address}" disabled>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Email</label>
                                    <input class="form-control" type="text" name="address" value="${account.email}" disabled>
                                </div>
                                <div class="col-sm-6">
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Citizen Identification</label>
                                    <div class="text-center">
                                        <img src="images/${account.imgLicense}" 
                                             alt="img" height="160px" width="340px">
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <label class="form-label">Car driving license</label>
                                    <div class="text-center">
                                        <img src="images/${account.imgLicense}" 
                                             alt="img" height="160px" width="340px">
                                    </div>
                                </div>
                            </div>
<!--                            <input type="submit" class="btn btn-primary" value="Save changes" style="margin-top: 20px">-->
                        </form>
                    </div>
                </div>
            </div>

            <div class="container">
                <div>
                    <div class="d-flex justify-content-center" style="margin-top: 50px;margin-bottom: 50px">
                        <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#exampleModal">
                            Restrict users
                        </button>
                    </div>
                    <form action="deleteuser?uid=${uid}" method="POST">
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Delete User</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        Are you sure you want to delete this User?
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
            <script src="js/script.js"></script>
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>



