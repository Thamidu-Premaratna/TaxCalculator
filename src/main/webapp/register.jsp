<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <style>
        /* Custom styles */
        body {
            background-image: url('bg.jpg'); /* Update with the path to your background image */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed; /* Ensure background stays fixed while scrolling */
            color: #fff; /* Set text color to white */
        }

        .container {
            padding-top: 50px;
            padding-bottom: 50px;
        }

        .card {
            background-color: rgba(0, 0, 0, 0.7); /* Semi-transparent background for better readability */
        }

        .card-footer a {
            color: #fff;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Register</div>
                <div class="card-body">
                    <form action="register-controller" method="post">
                        <div class="mb-3">
                            <label for="firstname" class="form-label">First Name:</label>
                            <input type="text" id="firstname" name="firstname" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="lastname" class="form-label">Last Name:</label>
                            <input type="text" id="lastname" name="lastname" class="form-control" required>
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
                            <label for="email" class="form-label">Email:</label>
                            <input type="email" id="email" name="email" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <button type="submit" class="btn btn-primary">Register</button>
                        </div>
                    </form>
                </div>
                <div class="card-footer text-muted">
                    Already have an account? <a href="login.jsp">Login</a>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
