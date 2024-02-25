<%--
  Created by IntelliJ IDEA.
  User: USHARI EGODAWELE
  Date: 2/19/2024
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

    <title>Login</title>
</head>
<body>
<h1 class="text-center mt-5 mb-4">Bootstrap Login page</h1>
<form class="container" style="width: 23rem">
    <!-- input fields -->
    <label>Username
    <input
            type="text"
            name="username"
            placeholder="Enter your username"
            class="form-control mb-4"
    />
    </label>

    <label>Password
    <input
            type="password"
            placeholder="Type password"
            class="form-control mb-4"
    />
    </label>

    <!-- check box and forgot password -->
    <div class="row text-center">
        <div class="col form-check">
            <input type="checkbox" checked />
            <label for="checkbox" id="checkbox">Remember me</label>
        </div>
        <div class="col"><a href="login.jsp">Forgot Password?</a></div>
    </div>

    <!-- sign in button -->
    <button class="btn btn-primary w-100 mt-4">Sign in</button>

    <!-- sign in with other services -->
    <p class="text-center mt-4">Not a member? <a href="login.jsp">Register</a></p>
    <p class="text-center">or sign up with:</p>
    <div class="row text-center d-flex justify-content-center mt-3">
        <div class="col-2">
            <a href="login.jsp"><i class="fab fa-facebook-f"></i></a>
        </div>
        <div class="col-2">
            <a href="login.jsp"><i class="fab fa-google"></i></a>
        </div>
        <div class="col-2">
            <a href="login.jsp"><i class="fab fa-twitter"></i></a>
        </div>
        <div class="col-2">
            <a href="login.jsp"><i class="fab fa-github"></i></a>
        </div>
    </div>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
