package com.project.taxcalculator.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login-servlet")
public class LoginController extends HttpServlet {

    public void init() {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the user credentials using UserDao
        UserDao userDao = new UserDao(DatabaseConnection.getConnection());
        User user = userDao.getUserByUsernameAndPassword(username, password);

        if (user != null) {
            // If the user is valid, set a session attribute indicating successful login
            request.getSession().setAttribute("loggedInUser", user);
            // Redirect to some success page
            response.sendRedirect("success.jsp");
        } else {
            // If the user is not valid, redirect back to the login page with an error message
            response.sendRedirect("login.jsp?error=invalid");
        }
    }

}
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//
//        //Storing the parameters as variables
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        //Create new Login object to store the parameters
//        User user = new User();
//        login.setUsername(username);
//        login.setPassword(password);
//
//        //Setting the role of the user
//        if(username.equals("admin")) {
//            login.setRole("admin");
//        } else {
//            login.setRole("user");
//        }
//}
