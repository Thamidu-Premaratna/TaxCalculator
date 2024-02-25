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

@WebServlet(name = "RegisterController", urlPatterns = {"/register-servlet"})
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("Content-Security-Policy", "script-src 'self'");

        // Get the error message that will be shown to user in case of errors.
        // And initializing it will a default message
        String errorMessage = "";

        // Get the success message that will be shown to user in case of successful operations.
        // And initializing it will a default message
        String successMessage = "";

        String firstname = StringEscapeUtils.escapeHtml4(request.getParameter("firstname"));
        String lastname = StringEscapeUtils.escapeHtml4(request.getParameter("lastname"));
        String username = StringEscapeUtils.escapeHtml4(request.getParameter("username"));
        String password = StringEscapeUtils.escapeHtml4(request.getParameter("password"));
        String email = StringEscapeUtils.escapeHtml4(request.getParameter("email"));

        if (firstname != null && !firstname.isEmpty() && lastname != null && !lastname.isEmpty()
                && username != null && !username.isEmpty() && password != null && !password.isEmpty()
                && email != null && !email.isEmpty()) {
            // Create a new user object
            User user = new User();
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            // Save the user to the database
            UserDao userDao = new UserDao();
            try {
                userDao.createUser(user);
            } catch (Exception e) {
                errorMessage = "Error occurred while creating your account!\nPlease try again!";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            }

            // Redirect to a index page after registration
            response.sendRedirect("login.jsp");
        } else {
            errorMessage = "Please fill all the fields!";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
