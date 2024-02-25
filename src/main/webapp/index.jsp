<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with,initial-scale=1">
    <meta name="description" content="This web application helps you to calculate your tax when you enter your gross salary as input. Includes the EPF/ ETF deductions also">
    <meta name="googlebot" content="index,follow">
    <meta name="keywords" content="tax calculator, tax calculator sl,tax calculator sri lanka, tax, tax deduction, epf, etf, employee provident fund, employees trust fund, salary, gross salary, income,tax calculator2024, srilanka, Sri Lanka, lanka, srilanka economy, SL, SL economy, ceylon, colombo, job, business, employee, employment, tin, taxpayer identification number, inflation, adayam badhu, gotago gama">

    <link rel="stylesheet" type="text/css" href="bootstrap-5.3.2-dist/bootstrap-5.3.2-dist/css/bootstrap.css">
    <title>Tax Calculator</title>
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

</body>
</html>