<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with,initial-scale=1">
    <meta name="description" content="Register to the Tax Calculator Web Service">
    <meta name="googlebot" content="index,follow">
    <meta name="keywords" content="register, tax calculator, tax calculator sl,tax calculator sri lanka, tax, tax deduction, epf, etf, employee provident fund, employees trust fund, salary, gross salary, income,tax calculator2024, srilanka, Sri Lanka, lanka, srilanka economy, SL, SL economy, ceylon, colombo, job, business, employee, employment, tin, taxpayer identification number, inflation, adayam badhu, gotago gama">
    <meta name="author" content="Faculty of Science, University of Kelaniya">

    <title>Register to Tax Calculator Web Service</title>
    <link rel="stylesheet" type="text/css" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css">
    <style>
        /* Custom styles */
        body {
            background-image: url('bg.jpg'); /* Update with the path to your background image */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed; /* Ensure background stays fixed while scrolling */
            color: #fff; /* Set text color to white */
        }

        .container {
            padding-top: 50px;
            padding-bottom: 50px;
        }

        .card {
            background-color: rgba(0, 0, 0, 0.3); /* Semi-transparent background for better readability */
            color: #fff; /* Set text color to white */
        }

        .card-footer {
            color: #fff; /* Set text color to white */
            text-decoration: none;
        }

        .card-footer a {
            color: #fff; /* Set link color to white */
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-white">Register</div>
                <div class="card-body text-white">
                    <form action="register-servlet" method="post">
                        <div class="mb-3">
                            <p class="text-danger">${errorMessage}</p>
                            <p class="text-success">${successMessage}</p>
                        </div>
                        <div class="mb-3">
                            <label for="firstname" class="form-label">First Name:</label>
                            <input type="text" id="firstname" name="firstname" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="lastname" class="form-label">Last Name:</label>
                            <input type="text" id="lastname" name="lastname" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="username" class="form-label">Username:</label>
                            <input type="text" id="username" name="username" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password:</label>
                            <input type="password" id="password" name="password" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email:</label>
                            <input type="email" id="email" name="email" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <button type="submit" class="btn btn-primary text-white">Register</button>
                        </div>
                    </form>
                </div>
                <div class="card-footer text-white">
                    Already have an account? <a href="login.jsp">Login</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
