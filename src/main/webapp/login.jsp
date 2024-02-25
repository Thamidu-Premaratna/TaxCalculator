<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with,initial-scale=1">
    <meta name="description" content="Login to the Tax Calculator Web Service, you can then save and see your Tax Calculation History">
    <meta name="googlebot" content="index,follow">
    <meta name="keywords" content="login, tax calculator, tax calculator sl,tax calculator sri lanka, tax, tax deduction, epf, etf, employee provident fund, employees trust fund, salary, gross salary, income,tax calculator2024, srilanka, Sri Lanka, lanka, srilanka economy, SL, SL economy, ceylon, colombo, job, business, employee, employment, tin, taxpayer identification number, inflation, adayam badhu, gotago gama">
    <meta name="author" content="Faculty of Science, University of Kelaniya">

    <title>Login to Tax Calculator Web Service</title>
    <link rel="stylesheet" type="text/css" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css">
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Login</div>
                <div class="card-body">
                    <!-- Login form -->
                    <form action="user-servlet" method="post">
                        <div class="mb-3">
                            <p class="text-danger">${errorMessage}</p>
                            <p class="text-success">${successMessage}</p>
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
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </form>
                </div>
                <div class="card-footer text-muted">
                    Don't have an account yet? <a href="register.jsp">Register</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS (optional, if you need JavaScript features) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
