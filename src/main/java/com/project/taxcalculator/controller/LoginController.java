package com.project.taxcalculator.controller;

import com.project.taxcalculator.dao.UserDao;
import com.project.taxcalculator.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if username or password is empty
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            // If either field is empty, redirect back to the login page with an error message
            response.sendRedirect("login.jsp?error=empty");
            return;
        }

        // Validate the user credentials using UserDao
        UserDao userDao = new UserDao();
        User user = userDao.getUserByUsernameAndPassword(username, password);

        if (user != null) {
            // If the user is valid, set a session attribute indicating successful login
            request.getSession().setAttribute("loggedInUser", user);
            // Redirect to some success page
            response.sendRedirect("index.jsp");
        } else {
            // If the user is not valid, redirect back to the login page with an error message
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
