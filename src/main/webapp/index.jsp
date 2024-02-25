<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with,initial-scale=1">
    <meta name="description"
          content="This web application helps you to calculate your tax when you enter your gross salary as input. Includes the EPF/ ETF deductions also">
    <meta name="googlebot" content="index,follow">
    <meta name="keywords"
          content="tax calculator, tax calculator sl,tax calculator sri lanka, tax, tax deduction, epf, etf, employee provident fund, employees trust fund, salary, gross salary, income,tax calculator2024, srilanka, Sri Lanka, lanka, srilanka economy, SL, SL economy, ceylon, colombo, job, business, employee, employment, tin, taxpayer identification number, inflation, adayam badhu, gotago gama">
    <meta name="author" content="Faculty of Science, University of Kelaniya">

    <title>Tax Calculator Web Service</title>
    <link rel="stylesheet" type="text/css" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css">

</head>
<body>
<nav class="navbar bg-body-tertiary mt-3 mb-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="19198919.jpg" alt="Tax-Calculator-Web-Application-Logo" width="30" height="24"
                 class="d-inline-block align-text-top">
            Tax Calculator Web Application
        </a>
<%--        Check if Session variables exist for User, if exist then use it otherwise show login link --%>

        <div class="d-flex">
            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <a href="login.jsp" class="btn btn-custom">Sign In</a>
                    <a href="register.jsp" class="btn btn-custom">Sign Up</a>
                </c:when>
                <c:otherwise>
                    <span class="navbar-text">
                        Welcome, ${sessionScope.loggedInUser.firstname}
                    </span>
                    <a href="register.jsp" class="btn btn-custom">Sign Up</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="text-center">
        <p style="color: white">This is a web application for calculating your tax payment based on your income. Enjoy
            it!</p>
    </div>
    <div class="card mx-auto" style="max-width: 600px;">
        <div class="card-header">
            <h5 class="card-title">Income Tax Calculator</h5>
        </div>
        <div class="card-body">
            <form class="row gy-2 gx-3 align-items-center" action="tax-servlet" method="POST">
                <div class="col-12">
                    <label for="InputSalary" class="form-label">Salary</label>
                    <input name="salary" type="number" class="form-control" id="InputSalary"
                           aria-describedby="salaryHelp">
                </div>
                <div class="form-check form-switch my-3 col-12">
                    <input name="isepfetf" class="form-check-input" type="checkbox" role="switch"
                           id="flexSwitchCheckChecked">
                    <label class="form-check-label " for="flexSwitchCheckChecked">Enable EPF/ETF calculation</label>
                </div>
                <button type="submit" class="btn btn-primary">Calculate</button>
            </form>
        </div>
    </div>
    <div class="text-center">
        <p class="my-1 text-danger">${errorMessage}</p>
        <p class="my-1 text-success">${successMessage}</p>
    </div>
    <div class="card mx-auto text-center text-bg-light p-3 mt-3" style="max-width: 600px;">
        <div class="card-header">
            <h5 class="card-title">EPF/ETF Calculations</h5>
        </div>
        <table class="table mb-1">
            <thead>
            <tr>
                <th scope="col">Calculation Type</th>
                <th scope="col">Rate</th>
                <th scope="col">Value (LKR)</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Employee EPF</td>
                <td>0.08</td>
                <td>${employeeEpf}</td>
            </tr>
            <tr>
                <td>Employer EPF</td>
                <td>0.12</td>
                <td>${employerEpf}</td>
            </tr>
            <tr>
                <td>Employer ETF</td>
                <td>0.03</td>
                <td>${employerEtf}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="card mx-auto text-center text-bg-light p-3 mt-3" style="max-width: 600px;">
        <div class="card-header">
            <h5 class="card-title">Tax Calculations</h5>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Taxable Income Range (LKR)</th>
                <th scope="col">Tax Rate</th>
                <th scope="col">Tax (LKR)</th>
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
            <tr>
                <td></td>
                <td>Total Tax</td>
                <td>${totalTax}</td>
            </tr>
            <tr>
                <td></td>
                <td>Total Employee EPF (deductions)</td>
                <td>${employeeEpf}</td>
            </tr>
            <tr>
                <td></td>
                <td>Take Home Salary</td>
                <td>${takeHomeSalary}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
