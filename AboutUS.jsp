<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About US</title>
</head>


<style>
    /* CSS Reset*/
    body {

        margin: 0px;
        padding: 0px;
        background: url('images/BG.jpg');
        color: white;
    }

    .left {
        display: inline-block;
        border: 2px solid white;
        position: absolute;
        left: 34px;
        top: 12px;

    }

    .left img {
        width: 100px;
    }

    .left div {
        text-align: center;
    }

    .mid {
        display: block;
        width: 30%;
        
        margin: 12px auto;
        border: 2px solid white;
    }

    .right {
        position: absolute;
        right: 34px;
        top: 12px;
        display: inline-block;
        border: 2px solid white;
    }

    .navbar {
        display: inline-block;
    }

    .navbar li {
        color: white;
        display: inline-block;
        font-size: 15px;
    }

    .navbar li a {
        color: white;
        text-decoration: none;
        padding: 15px 10px;
        

    }

    .navbar li a:hover,
    .navbar li a:active {
        color: grey;
        text-decoration: underline;


    }

    .btn {
        margin: 9px;
        background-color: black;
        color: white;
        padding: 4px 14px;
        border: 2px solid grey;
        border-radius: 10px;
        font-size: 20px;
        cursor: pointer;
    }

    .btn:hover {
        background-color: grey;
    }

    .container {
        border: 2px solid white;
        margin: 100px auto;
        padding: 75px 75px;
        width: 33%;
        border-radius: 10px;
    }
    .form-group input{
      text-align:center;
      display:block;
      width:500px;
      padding:1px;
      margin: 3px auto ;
      border: 2px solid black; 
      font-size: 15px;
      border-radius: 8px;
    }
    .container h4{
      text-align:center;
      
    }
    .container button{
      display:block;
      width:23%;
      margin: auto ;
    }
</style>


<body>
   
    <!-- Your HTML content goes here -->
    <header class="header">
        <!-- left box for logo -->
        <div class="left">
            <img src="images/logo.jpg" alt="">
            <div>Fitness</div>
        </div>
        <!-- mid box for navigation bar -->
        <div class="mid">
            <ul class="navbar">
                <li><a href="UHP.jsp">Login</a></li>
                <li><a href="AboutUS.jsp">About Us</a></li>
                <li><a href="Calc.jsp">Fitness Calculator</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
        <!-- right box for button -->
       
    </header>
    <div class="container">
        <h1>WELCOME TO TRACKFLEX!!</h1>
        <h4>Fitness is not just about exercise; nutrition plays a crucial role, and users often struggle to
            track and manage their dietary intake.
            TRACKFLEX aims to address this need by providing a centralized platform for users to store,
            retrieve, and analyse their fitness data</h4>
             
        <h4>TRACKFLEX facilitates the organization and
             accessibility of information, offering users a seamless experience in tracking their fitness
             progress and making informed decisions to enhance their overall health and well-being.</h4>
             </div>
     
    
 </body>
</html>