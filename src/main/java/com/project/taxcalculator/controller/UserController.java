package com.project.taxcalculator.controller;

import java.io.*;

import com.project.taxcalculator.dao.UserDao;
import com.project.taxcalculator.model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UserController", value = "/user-servlet")
public class UserController extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

//Storing the parameters as variables
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        //Create new Login object to store the parameters
        User user = new User();
        user.setFirstname(firstname);
        user.getLastname(lastname);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        //Setting the role of the user
//        if(username.equals("admin")) {
//            user.setRole("admin");
//        } else {
//            user.setRole("user");
//        }
//    }

    try {
        // Get the servlet context
        ServletContext context = getServletContext();

        // Use the servlet context's real path to the webapp root directory
        String rootPath = context.getRealPath("/");

        // Instantiate the class that handles the data access
        UserDao loginDao = new UserDao(rootPath, user);

//----------------------must edit----------------------
        //Check if the login is successful and get the role of the user
        String msg = loginDao.getLogin();
        if(msg.equals("ok")) {
            // Move to employeeview.jsp with the login attributes
            request.setAttribute("role", login.getRole());
            request.getRequestDispatcher("employeeview.jsp").forward(request, response);
        } else {
            // Move to index.jsp with the error message
            request.setAttribute("error_msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    } catch (JAXBException e) {
        e.printStackTrace();
    }
//----------------------
}

    public void destroy() {
    }
}