<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css">
    <title>Tax Calculator Web Service</title>
</head>
<body >

<nav class="navbar bg-body-tertiary mt-3 mb-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
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

            <form class="row gy-2 gx-3 align-items-center" action="tax-servlet" method="GET">
                <div class="col-auto">
                    <label for="InputSalary" class="form-label">Salary</label>
                    <input name="salary" type="number" class="form-control" id="InputSalary" aria-describedby="salaryHelp">
                </div>

                <div class="form-check form-switch mt-3 col-lg-6">
                    <input name="isepfetf" class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked">
                    <label class="form-check-label " for="flexSwitchCheckChecked">enable EPF/ETF calculation</label>
                </div>

                <button type="submit" class="btn btn-primary mt-3">calculate</button>

            </form>
        </div>


    </div>

    <p class="mt-4">Tax Brackets and Rates</p>
    <p class="my-1 text-danger">${errorMessage}</p>
    <p class="my-1 text-success">${successMessage}</p>

    <div class="card text-center text-bg-light p-3 mt-3" style="max-width: 600px;">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Taxable Income Range (LKR)</th>
                <th scope="col">Tax Rate (%)</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="taxBracket" items="${taxbrackets}">
                <tr>
                    <td>${taxBracket.bracketSalaryRange}</td>
                    <td>${taxBracket.taxRate}</td>
                    <td>${taxBracket.tax}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

</body>
</html>