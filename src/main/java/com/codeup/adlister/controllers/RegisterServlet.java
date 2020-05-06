package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.RemoteException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        String passwordConfirmation = request.getParameter("confirm_password");
        String zip = (request.getParameter("zip"));
//
//        public int validateZip(String zip){
//            int validZip;
//            try {
//                if (zip.length() == 5){
//                    validZip = Integer.parseInt(zip);
//                }
//            } catch (NumberFormatException nfe){
//                throw new RuntimeException("Incorrect format");
//            }
//            return validZip;
//        }

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));


        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username, email, hash);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
