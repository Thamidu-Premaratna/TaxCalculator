package com.project.taxcalculator.controller;

import com.project.taxcalculator.dao.UserDao;
import com.project.taxcalculator.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", urlPatterns = {"/register-servlet"})
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

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
            userDao.createUser(user);

            // Redirect to a success page after registration
            response.sendRedirect("login.jsp");
        } else {
            // If any field is empty, redirect back to the registration page with an error message
            response.sendRedirect("register.jsp?error=empty");
        }
    }
}
