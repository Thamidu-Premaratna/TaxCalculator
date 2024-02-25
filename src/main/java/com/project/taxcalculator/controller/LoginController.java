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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        //Storing the parameters as variables
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //Create new User object to store the parameters
        User user = new User();
        User.setUsername(username);
        login.setPassword(password);

        //Setting the role of the user
        if(username.equals("admin")) {
            login.setRole("admin");
        } else {
            login.setRole("user");
        }
}
