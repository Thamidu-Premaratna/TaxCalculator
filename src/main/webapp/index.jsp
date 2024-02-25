<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tax Calculator Web Service</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <style>
        /* Custom styles */
        body {
            background-image: url('bg.jpg'); /* Update with the path to your background image */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed; /* Ensure background stays fixed while scrolling */
            color: #000000; /* Set text color to white */
        }

        .navbar-brand img {
            margin-right: 5px;
        }

        .container {
            padding-top: 50px;
            padding-bottom: 50px;
        }

        .text-center {
            text-align: center;
        }

        .mt-4 {
            margin-top: 4rem;
        }

        .btn-custom {
            background-color: transparent;
            border: 1px solid #fff;
            color: #fff;
            margin-left: 10px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="login.jsp">
            <img src="19198919.jpg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            Tax Calculator Web Application
        </a>
        <div class="d-flex">
            <a href="login.jsp" class="btn btn-custom">Sign In</a>
            <a href="register.jsp" class="btn btn-custom">Sign Up</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="text-center">
        <p style="color: white">This is a web application for calculating your tax payment based on your income. Enjoy it!</p>
    </div>

    <<div class="card mx-auto" style="max-width: 600px;">
        <div class="card-header">
            <h5 class="card-title">Income Tax Calculator</h5>
        </div>
        <div class="card-body">
            <form action="hello-servlet" method="GET">
                <div class="row mb-3">
                    <div class="col">
                        <label for="InputSalary" class="form-label">Salary</label>
                        <input type="number" class="form-control" id="InputSalary" aria-describedby="salaryHelp">
                    </div>
                    <div class="col">
                        <label for="autoSizingSelect0" class="form-label">Currency</label>
                        <select class="form-select" id="autoSizingSelect0">
                            <option selected>Select Currency</option>
                            <option value="1">SL Rupee(Rs.)</option>
                            <option value="2">US Dolors($)</option>
                        </select>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col">
                        <label for="autoSizingSelect1" class="form-label">For</label>
                        <select class="form-select" id="autoSizingSelect1">
                            <option value="1">Month</option>
                            <option value="2">Year</option>
                        </select>
                    </div>
                </div>
                <div class="form-check mb-3">
                    <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked">
                    <label class="form-check-label" for="flexSwitchCheckChecked">Enable EPF/ETF calculation</label>
                </div>
                <button type="submit" class="btn btn-primary">Calculate</button>
            </form>
        </div>
    </div>
    <div class="text-center">
    <p class="mt-4" style="color: white">Tax Brackets and Rates</p>
    </div>
    <div class="card mx-auto" style="max-width: 600px;">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Taxable Income Range (LKR)</th>
                <th scope="col">Tax Rate (%)</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Up to 100,000</td>
                <td>0</td>
            </tr>
            <tr>
                <td>100,000 - 141,667</td>
                <td>6</td>
            </tr>
            <tr>
                <td>141,667 - 183,333</td>
                <td>12</td>
            </tr>
            <tr>
                <td>183,333 - 225,000</td>
                <td>18</td>
            </tr>
            <tr>
                <td>225,000 - 266,667</td>
                <td>24</td>
            </tr>
            <tr>
                <td>266,667 - 308,333</td>
                <td>30</td>
            </tr>
            <tr>
                <td>Above 308,333</td>
                <td>36</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
