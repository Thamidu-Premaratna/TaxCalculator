<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2/22/2024
  Time: 1:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <link rel="stylesheet" href="styleh.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<section class="header">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light">
            <a class="navbar-brand" href="#"><img src="https://i.ya-webdesign.com/images/spiderman-logo-png-7.png"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto text-right">
                    <li class="nav-item">
                        <a class="nav-link active-home" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="home.jsp">Gallery</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Contact Us</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="row banner">
            <div class="col-md-6">
                <h1>WATCH OUT!<br>For the <span id="hero">Spider-Man</span></h1>
                <p>Spider-Man is your friendly neighborhood hero! Watch him now at theaters</p>
                <a href="#" class="express-btn">View Trailer</a>
            </div>
            <div class="col-md-6">
                <img src="http://www.pngall.com/wp-content/uploads/2016/05/Spider-Man-PNG-Picture.png" class="img-fluid">
            </div>
        </div>
    </div>
</section>
</body>
</html>

