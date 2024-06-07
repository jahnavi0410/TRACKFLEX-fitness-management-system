<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BMI and BMR Calculator</title>
    <style>
        /* CSS Reset*/
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

        .navbar {
            display: inline-block;
        }

        .navbar li {
            color: white;
            display: inline-block;
            font-size: 15px;
            margin-right: 10px;
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

        .container {
            border: 2px solid white;
            margin: 100px auto;
            padding: 75px;
            width: 33%;
            border-radius: 10px;
        }

        .form-group input {
            text-align: center;
            display: block;
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 2px solid black;
            font-size: 15px;
            border-radius: 8px;
        }

        .container h2 {
            text-align: center;
        }

        .container button {
            display: block;
            width: 23%;
            margin: auto;
            background-color: black;
            color: white;
            padding: 10px;
            border: 2px solid grey;
            border-radius: 10px;
            font-size: 20px;
            cursor: pointer;
        }

        .container button:hover {
            background-color: grey;
        }
    </style>
</head>
<body>

    <header class="header">
        <!-- left box for logo -->
        <div class="navbar">
            <ul>
                <li><a href="UHP.jsp">Login</a></li>
                <li><a href="AboutUS.jsp">About Us</a></li>
                <li><a href="Calc.jsp">Fitness Calculator</a></li>
                <li><a href="#">Menu</a></li>
            </ul>
        </div>
    </header>

    <div class="container">
        <h2>BMI and BMR Calculator</h2>

        <form action="CalculateServlet" method="post">
            <div class="form-group">
                <label for="weight">Weight (kg):</label>
                <input type="text" name="weight" required>
            </div>

            <div class="form-group">
                <label for="height">Height (cm):</label>
                <input type="text" name="height" required>
            </div>

            <div class="form-group">
                <label for="age">Age:</label>
                <input type="text" name="age" required>
            </div>

            <div class="form-group">
                <label for="gender">Gender:</label>
                <select name="gender">
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
            </div>

            <button type="submit">Calculate</button>
        </form>
    </div>

</body>
</html>
