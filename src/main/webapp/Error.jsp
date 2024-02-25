<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        .container {
            margin-top: 100px;
        }
        h1 {
            color: #d9534f;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Oops! An error occurred.</h1>
    <p class="text-danger mb-1">${errorMessage}</p>
    <p>We apologize for the inconvenience. Please try again later.</p>
    <p>If you continue to experience issues, please contact support.</p>
</div>
</body>
</html>
