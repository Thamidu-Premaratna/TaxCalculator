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
          content="tax history, tax calculator, tax calculator sl,tax calculator sri lanka, tax, tax deduction, epf, etf, employee provident fund, employees trust fund, salary, gross salary, income,tax calculator2024, srilanka, Sri Lanka, lanka, srilanka economy, SL, SL economy, ceylon, colombo, job, business, employee, employment, tin, taxpayer identification number, inflation, adayam badhu, gotago gama">
    <meta name="author" content="Faculty of Science, University of Kelaniya">

    <title>Tax Calculator Web Service - Tax History</title>
    <link rel="stylesheet" type="text/css" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css">

</head>
<body>
<nav class="navbar bg-body-tertiary mt-3 mb-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">
            <img src="19198919.jpg" alt="Tax-Calculator-Web-Application-Logo" width="30" height="24"
                 class="d-inline-block align-text-top">
            Tax Calculator Web Application
        </a>
        <%--        Check if Session variables exist for User, if exist then use it otherwise show login link --%>
        <div class="d-flex">
            <c:choose>
                <c:when test="${empty sessionScope.loggedInUser}">
                    <a href="login.jsp" class="btn btn-custom">Sign In</a>
                    <a href="register.jsp" class="btn btn-custom">Sign Up</a>
                </c:when>
                <c:otherwise>
                    <span class="navbar-text">
                        Welcome, ${sessionScope.loggedInUser.firstname}
                    </span>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>
<%--        Check if Session variables exist for User, if exist then show tax hisotry otherwise show that user needs to login --%>
<c:choose>
    <c:when test="${empty sessionScope.loggedInUser}">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h6 class="text-muted">Please login to see your tax history!</h6>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="container mt-5">
            <div class="text-center">
                <p style="color: white">This shows all the tax calculations done by you! It shows you the tax
                    history!</p>
            </div>
            <c:choose>
                <c:when test="${empty errorMessage}">
                    <div class="card mx-auto text-center text-bg-light p-3 mt-3" style="max-width: 1024px;">
                        <div class="card-header">
                            <h5 class="card-title">Tax Calculations History</h5>
                        </div>
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Gross Salary (LKR)</th>
                                <th scope="col">Total Tax Value (LKR)</th>
                                <th scope="col">Employee EPF (LKR)</th>
                                <th scope="col">Employer EPF (LKR)</th>
                                <th scope="col">Employer ETF (LKR)</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="taxHistory" items="${taxHistories}">
                                <tr>
                                    <td>${taxHistory.grosssalary}</td>
                                    <td>${taxHistory.taxvalue}</td>
                                    <td>${taxHistory.employeeEpf}</td>
                                    <td>${taxHistory.employerEpf}</td>
                                    <td>${taxHistory.employerEtf}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="text-center">
                        <p class="my-1 text-danger">${errorMessage}</p>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </c:otherwise>
</c:choose>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
