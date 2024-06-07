<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BMI and BMR Results</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: url('images/BG.jpg');
            color: white;
        }

        .header {
            text-align: center;
            padding: 12px;
            background-color: #333;
        }

        .header img {
            width: 100px;
        }

        .header div {
            text-align: center;
        }

        .container {
            border: 2px solid white;
            margin: 100px auto;
            padding: 75px;
            width: 33%;
            border-radius: 10px;
        }

        .result {
            text-align: center;
            font-size: 20px;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <header class="header">
        <!-- left box for logo -->
        <div class="navbar">
            <ul>
                <li><a href="UHP.jsp">Home</a></li>
                <li><a href="AboutUS.jsp">About Us</a></li>
                <li><a href="#">Fitness Calculator</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
    </header>

    <div class="container">
        <h2>BMI and BMR Results</h2>

        <div class="result">
            <p>BMI: <%= request.getAttribute("bmiResult") %></p>
            <p>BMR: <%= request.getAttribute("bmrResult") %></p>
        </div>
    </div>

</body>
</html>
