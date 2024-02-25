// LoginController.java
package com.project.taxcalculator.controller;

import com.project.taxcalculator.dao.UserDao;
import com.project.taxcalculator.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/login-servlet"})
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("Content-Security-Policy", "script-src 'self'");

        // Get the error message that will be shown to user in case of errors.
        // And initializing it will a default message
        String errorMessage = "";

        // Get the success message that will be shown to user in case of successful operations.
        // And initializing it will a default message
        String successMessage = "";

        // Retrieve username and password from the request
        String username = StringEscapeUtils.escapeHtml4(request.getParameter("username"));
        String password = StringEscapeUtils.escapeHtml4(request.getParameter("password"));

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
            // If the user is invalid, redirect back to the login page with an error message
            errorMessage = "Invalid username or password!";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
