<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%--    <link rel="stylesheet" type="text/css" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css">--%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<%--    <link rel="stylesheet" href="indexStyle.css">--%>

    <title>Tax Calculator Web Service</title>
</head>
<body >

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-body-tertiary">
    <!-- Container wrapper -->
    <div class="container">
        <!-- Navbar brand -->
        <a class="navbar-brand me-2" href="https://mdbgo.com/">
            <img
                    src="https://mdbcdn.b-cdn.net/img/logo/mdb-transaprent-noshadows.webp"
                    height="16"
                    alt="MDB Logo"
                    loading="lazy"
                    style="margin-top: -1px;"
            />
        </a>

        <!-- Toggle button -->
        <button
                data-mdb-collapse-init
                class="navbar-toggler"
                type="button"
                data-mdb-target="#navbarButtonsExample"
                aria-controls="navbarButtonsExample"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars"></i>
        </button>

        <!-- Collapsible wrapper -->
        <div class="collapse navbar-collapse" id="navbarButtonsExample">
            <!-- Left links -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="#">Dashboard</a>
                </li>
            </ul>
            <!-- Left links -->

            <div class="d-flex align-items-center">
                <button data-mdb-ripple-init type="button" class="btn btn-link px-3 me-2">
                    Login
                </button>
                <button data-mdb-ripple-init type="button" class="btn btn-primary me-3">
                    Sign up for free
                </button>
                <a
                        data-mdb-ripple-init
                        class="btn btn-dark px-3"
                        href="https://github.com/mdbootstrap/mdb-ui-kit"
                        role="button"
                ><i class="fab fa-github"></i
                ></a>
            </div>
        </div>
        <!-- Collapsible wrapper -->
    </div>
    <!-- Container wrapper -->
</nav>
<!-- Navbar -->

<nav class="navbar bg-body-tertiary mt-3 mb-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="home.jsp">
            <img src="19198919.jpg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
            Tax Calculator Web Application
        </a>
    </div>
</nav>

<div class="container align-content-center">
    <p>This is a web application for calculating your tax payment based on your income. Enjoy it!</p>

    <div class="card text-center text-bg-light p-3 " style="max-width: 600px;">

        <div class="card-header">
            <h5 class="card-title">Income Tax Calculator</h5>
        </div>

        <div class="card-body">

            <form class="row gy-2 gx-3 align-items-center" action="hello-servlet" method="GET">
                <div class="col-auto">
                    <label for="InputSalary" class="form-label">Salary</label>
                    <input type="number" class="form-control" id="InputSalary" aria-describedby="salaryHelp">
                </div>
                <div class="col-auto">
                    <label for="autoSizingSelect0" class="form-label">Currency</label>
                    <label class="visually-hidden" for="autoSizingSelect0">Preference</label>
                    <select class="form-select" id="autoSizingSelect0">
                        <option selected>Select Currency</option>
                        <option value="1">SL Rupee(Rs.)</option>
                        <option value="2">US Dolors($)</option>
                    </select>
                </div>

                <div class="col-auto">
                    <label for="autoSizingSelect1" class="form-label">for</label>
                    <label class="visually-hidden" for="autoSizingSelect1">for</label>
                    <select class="form-select" id="autoSizingSelect1">
                        <option value="1">Month</option>
                        <option value="2">Year</option>
                    </select>
                </div>

                <div class="form-check form-switch mt-3 col-lg-6">
                    <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked">
                    <label class="form-check-label " for="flexSwitchCheckChecked">enable EPF/ETF calculation</label>
                </div>

                <button type="submit" class="btn btn-primary mt-3">calculate</button>

            </form>
        </div>


    </div>

    <p class="mt-4">Tax Brackets and Rates</p>

    <div class="card text-center text-bg-light p-3 mt-3" style="max-width: 600px;">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Taxable Income Range (LKR)</th>
                <th scope="col">Tax Rate (%)</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Up to 100,000 </td>
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
                <td>266,667 - 308,333 </td>
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

<script src="indexjs.js"></script>
</body>
</html>