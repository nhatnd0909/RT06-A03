<%-- 
    Document   : profile.jsp
    Created on : May 25, 2023, 11:12:49 AM
    Author     : ACER
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <head>
        <title>Profile</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
            .file-upload{
                display:block;
                text-align:center;
                font-family: Helvetica, Arial, sans-serif;
                font-size: 12px;
            }
            .file-upload .file-select{
                display:block;
                border: 2px solid #dce4ec;
                color: #34495e;
                cursor:pointer;
                height:40px;
                line-height:40px;
                text-align:left;
                background:#FFFFFF;
                overflow:hidden;
                position:relative;
            }
            .file-upload .file-select .file-select-button{
                background:#dce4ec;
                padding:0 10px;
                display:inline-block;
                height:40px;
                line-height:40px;
            }
            .file-upload .file-select .file-select-name{
                line-height:40px;
                display:inline-block;
                padding:0 10px;
            }
            .file-upload .file-select:hover{
                border-color:#34495e;
                transition:all .2s ease-in-out;
                -moz-transition:all .2s ease-in-out;
                -webkit-transition:all .2s ease-in-out;
                -o-transition:all .2s ease-in-out;
            }
            .file-upload .file-select:hover .file-select-button{
                background:#34495e;
                color:#FFFFFF;
                transition:all .2s ease-in-out;
                -moz-transition:all .2s ease-in-out;
                -webkit-transition:all .2s ease-in-out;
                -o-transition:all .2s ease-in-out;
            }
            .file-upload.active .file-select{
                border-color:#3fa46a;
                transition:all .2s ease-in-out;
                -moz-transition:all .2s ease-in-out;
                -webkit-transition:all .2s ease-in-out;
                -o-transition:all .2s ease-in-out;
            }
            .file-upload.active .file-select .file-select-button{
                background:#3fa46a;
                color:#FFFFFF;
                transition:all .2s ease-in-out;
                -moz-transition:all .2s ease-in-out;
                -webkit-transition:all .2s ease-in-out;
                -o-transition:all .2s ease-in-out;
            }
            .file-upload .file-select input[type=file]{
                z-index:100;
                cursor:pointer;
                position:absolute;
                height:100%;
                width:100%;
                top:0;
                left:0;
                opacity:0;
                filter:alpha(opacity=0);
            }
            .file-upload .file-select.file-select-disabled{
                opacity:0.65;
            }
            .file-upload .file-select.file-select-disabled:hover{
                cursor:default;
                display:block;
                border: 2px solid #dce4ec;
                color: #34495e;
                cursor:pointer;
                height:40px;
                line-height:40px;
                margin-top:5px;
                text-align:left;
                background:#FFFFFF;
                overflow:hidden;
                position:relative;
            }
            .file-upload .file-select.file-select-disabled:hover .file-select-button{
                background:#dce4ec;
                color:#666666;
                padding:0 10px;
                display:inline-block;
                height:40px;
                line-height:40px;
            }
            .file-upload .file-select.file-select-disabled:hover .file-select-name{
                line-height:40px;
                display:inline-block;
                padding:0 10px;
            }



            .file-upload-2{
                display:block;
                text-align:center;
                font-family: Helvetica, Arial, sans-serif;
                font-size: 12px;
            }
            .file-upload-2 .file-select{
                display:block;
                border: 2px solid #dce4ec;
                color: #34495e;
                cursor:pointer;
                height:40px;
                line-height:40px;
                text-align:left;
                background:#FFFFFF;
                overflow:hidden;
                position:relative;
            }
            .file-upload-2 .file-select .file-select-button{
                background:#dce4ec;
                padding:0 10px;
                display:inline-block;
                height:40px;
                line-height:40px;
            }
            .file-upload-2 .file-select .file-select-name{
                line-height:40px;
                display:inline-block;
                padding:0 10px;
            }
            .file-upload-2 .file-select:hover{
                border-color:#34495e;
                transition:all .2s ease-in-out;
                -moz-transition:all .2s ease-in-out;
                -webkit-transition:all .2s ease-in-out;
                -o-transition:all .2s ease-in-out;
            }
            .file-upload-2 .file-select:hover .file-select-button{
                background:#34495e;
                color:#FFFFFF;
                transition:all .2s ease-in-out;
                -moz-transition:all .2s ease-in-out;
                -webkit-transition:all .2s ease-in-out;
                -o-transition:all .2s ease-in-out;
            }
            .file-upload-2.active .file-select{
                border-color:#3fa46a;
                transition:all .2s ease-in-out;
                -moz-transition:all .2s ease-in-out;
                -webkit-transition:all .2s ease-in-out;
                -o-transition:all .2s ease-in-out;
            }
            .file-upload-2.active .file-select .file-select-button{
                background:#3fa46a;
                color:#FFFFFF;
                transition:all .2s ease-in-out;
                -moz-transition:all .2s ease-in-out;
                -webkit-transition:all .2s ease-in-out;
                -o-transition:all .2s ease-in-out;
            }
            .file-upload-2 .file-select input[type=file]{
                z-index:100;
                cursor:pointer;
                position:absolute;
                height:100%;
                width:100%;
                top:0;
                left:0;
                opacity:0;
                filter:alpha(opacity=0);
            }
            .file-upload-2 .file-select.file-select-disabled{
                opacity:0.65;
            }
            .file-upload-2 .file-select.file-select-disabled:hover{
                cursor:default;
                display:block;
                border: 2px solid #dce4ec;
                color: #34495e;
                cursor:pointer;
                height:40px;
                line-height:40px;
                margin-top:5px;
                text-align:left;
                background:#FFFFFF;
                overflow:hidden;
                position:relative;
            }
            .file-upload-2 .file-select.file-select-disabled:hover .file-select-button{
                background:#dce4ec;
                color:#666666;
                padding:0 10px;
                display:inline-block;
                height:40px;
                line-height:40px;
            }
            .file-upload-2 .file-select.file-select-disabled:hover .file-select-name{
                line-height:40px;
                display:inline-block;
                padding:0 10px;
            }
        </style>
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
                            <li class="nav-item"><a href="loginform" class="nav-link">Login</a></li>
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
                        <h1 class="mb-3 bread">Profile</h1>
                    </div>
                </div>
            </div>
        </section>
        <hr>
        <div class="container bootstrap snippet">
            <div class="row">
                <div class="col-sm-10">
                    <h1>${account.name}</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-3"><!--left col-->
                    <div class="text-center">
                        <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail"
                             alt="avatar">
                    </div>
                    </hr><br>   
                </div><!--/col-3-->
                <div class="col-sm-9">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#profile">Profile</a></li>
                        <li><a href="historybooking">History Booking</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="profile">
                            <form class="form" action="profile?id=${sessionScope.id}" method="post" id="profile">
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label>
                                            <h4>Name</h4>
                                        </label>
                                        <input type="text" value="${account.name}" class="form-control" name="name" placeholder="Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label>
                                            <h4>Username</h4>
                                        </label>
                                        <input type="text" value="${account.userName}" class="form-control" name="username"
                                               placeholder="Username" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label>
                                            <h4>Phone</h4>
                                        </label>
                                        <input type="text" value="${account.phone}" class="form-control" name="phone"
                                               placeholder="enter phone" pattern="(84|0[3|5|7|8|9])+([0-9]{8})">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label>
                                            <h4>Day of Birth</h4>
                                        </label>
                                        <input type="date" value="${account.DOB}" class="form-control" name="dob"
                                               placeholder="enter your day of birth" min="1900-01-01">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label>
                                            <h4>Gender</h4>
                                        </label>
<!--                                        <input type="text" value="${account.gender}" class="form-control" name="gender"
                                               placeholder="enter you gender">-->
                                        <select class="form-control" name="gender">
                                            <c:if test="${test == 1}">
                                                <option value="Male" selected="">Male</option>
                                                <option value="Female">Female</option>
                                            </c:if>
                                            <c:if test="${test == 0}">
                                                <option value="Male" >Male</option>
                                                <option value="Female" selected="">Female</option>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="col-xs-6">
                                        <label for="email">
                                            <h4>Email</h4>
                                        </label>
                                        <input type="email" value="${account.email}" class="form-control" name="email" id="email"
                                               placeholder="your@email.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <label for="email">
                                            <h4>Address</h4>
                                        </label>
                                        <input name="address" type="text" class="form-control" value="${add}" >
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="email">
                                            <h4>Province/ City</h4>
                                        </label>
                                        <input name="city" type="text" class="form-control" value="${city}" > 
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="email">
                                            <h4>District</h4>
                                        </label>
                                        <input name="district" type="text" class="form-control" value="${district}" >   
                                    </div>
                                    <div class="col-xs-4">
                                        <label for="email">
                                            <h4>Wards</h4>
                                        </label>
                                        <input name="wards" type="text" class="form-control" value="${wards}" >  
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="address">
                                            <h4>Citizen identification</h4>
                                        </label>
                                        <div class="text-center">
                                            <img src="images/${account.imgCCCD}" 
                                                 alt="img" height="160px" width="350px">
                                        </div>
                                        <div class="file-upload">
                                            <div class="file-select">
                                                <div class="file-select-button" id="fileName">Choose File</div>
                                                <div class="file-select-name" id="noFile">No file chosen...</div> 
                                                <input type="file" name="ci" id="chooseFile" accept="image/*">
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label for="address">
                                            <h4>Car driving license</h4>
                                        </label>
                                        <div class="text-center">
                                            <img src="images/${account.imgLicense}" 
                                                 alt="img" height="160px" width="350px">
                                        </div>
                                        <div class="file-upload-2">
                                            <div class="file-select">
                                                <div class="file-select-button" id="fileName2">Choose File</div>
                                                <div class="file-select-name" id="noFile2">No file chosen...</div> 
                                                <input type="file" name="dl" id="chooseFile2" accept="image/*">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <br>
                                        <button type="button" class="btn btn-light" onclick="changePass()">Change
                                            Password</button>
                                        <p class="text-warning" style="font-size: 20px">${mess}</p>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <br>
                                        <button class="btn btn-lg btn-success" type="submit"><i
                                                class="glyphicon glyphicon-ok-sign"></i> Update Profile</button>
                                    </div>
                                </div>
                            </form>
                            <div class="tab-pane" id="changePass1">
                                <form class="form" action="changePass?id=${sessionScope.id}" method="post" id="changePass" style="display: none;">

                                    <div class="form-group" style="width: 50%;">
                                        <div class="col-xs-12">

                                            <label for="odd-pass">
                                            </label>
                                            <input type="password" class="form-control" name="oddPass" id="oddPass"
                                                   placeholder="Ente your odd password" required>
                                        </div>
                                    </div>
                                    <div class="form-group" style="width: 50%;">
                                        <div class="col-xs-12">
                                            <label for="new-pass">
                                            </label>
                                            <input type="password" class="form-control" name="newPass" id="newPass"
                                                   placeholder="Enter your new password" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,32}$" required>
                                        </div>
                                    </div>
                                    <div class="form-group" style="width: 50%;">
                                        <div class="col-xs-12">
                                            <label for="re-pass">
                                            </label>
                                            <input type="password" class="form-control" name="rePass" id="rePass"
                                                   placeholder="Confirm new password" required>
                                            <lable style="color: #000">*Password must contains 3-32 characters, at least 1 uppercase 1 lowercase</lable>
                                        </div>
                                    </div>                        
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <br>
                                            <button class="btn btn-lg btn-success pull-left" type="submit"
                                                    style="margin-bottom: 30px;"><i class="glyphicon glyphicon-ok-sign"></i>
                                                Change Password</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div><!--/tab-pane-->    
                    </div><!--/tab-content-->
                </div>
            </div><!--/col-9-->
        </div><!--/row-->
        <script type="text/javascript">
            function changePass() {
                if (document.getElementById('changePass').style.display === "none") {
                    document.getElementById('changePass').style.display = "block";
                } else {
                    document.getElementById('changePass').style.display = "none";
                }
            }
        </script>
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
        <script>
            $('#chooseFile').bind('change', function () {
                var filename = $("#chooseFile").val();
                if (/^\s*$/.test(filename)) {
                    $(".file-upload").removeClass('active');
                    $("#noFile").text("No file chosen...");
                } else {
                    $(".file-upload").addClass('active');
                    $("#noFile").text(filename.replace("C:\\fakepath\\", ""));
                }
            });

            $('#chooseFile2').bind('change', function () {
                var filename = $("#chooseFile2").val();
                if (/^\s*$/.test(filename)) {
                    $(".file-upload-2").removeClass('active');
                    $("#noFile2").text("No file chosen...");
                } else {
                    $(".file-upload-2").addClass('active');
                    $("#noFile2").text(filename.replace("C:\\fakepath\\", ""));
                }
            });
        </script>
    </body>
</html>

