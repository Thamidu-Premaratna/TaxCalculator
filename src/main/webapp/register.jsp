<%--
  Created by IntelliJ IDEA.
  User: USHARI EGODAWELE
  Date: 2/25/2024
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
    <title>Registration Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<div class="signup-form">
    <form action="/examples/actions/confirmation.php" method="post">
        <h2>Register here!</h2>
        <div class="form-group">
            <div class="row">
                <div class="col-xs-6">
                    <label>Firstname
                        <input type="text" class="form-control" name="first_name" placeholder="First Name" required="required">
                    </label>
                </div>
                <div class="col-xs-6">
                <label>Lastname
                    <input type="text" class="form-control" name="last_name" placeholder="Last Name" required="required">
                </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label>Email
                <input type="email" class="form-control" name="email" placeholder="Email" required="required">
            </label>
        </div>
        <div class="form-group">
            <label>Password
                <input type="password" class="form-control" name="password" placeholder="Password" required="required">
            </label>
        </div>
        <label>
        <div class="form-group">
            <label>Confirm Password
                <input type="password" class="form-control" name="confirm_password" placeholder="Confirm Password" required="required">
            </label>
        </div>
        <div class="form-group">
            <label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a></label>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
        </div>
    </form>
    <div class="text-center">Already have an account? <a href="#">Sign in</a>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>