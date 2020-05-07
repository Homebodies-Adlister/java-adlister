package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.codeup.adlister.controllers.RegisterServlet.validateZip;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/profile/edit")
public class UpdateUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirm_newPassword");
        String hash = Password.hash(newPassword);
        String zip = req.getParameter("zip");

        // update what was changed
        if (!email.isEmpty()) {
            user.setEmail(email);
        }

        if (!zip.isEmpty()) {
            user.setZip(validateZip(zip));
        }

        if (!(password.isEmpty() && newPassword.isEmpty() && confirmPassword.isEmpty())) {
            if (Password.check(password, user.getPassword()) && newPassword.equals(confirmPassword)) {
                user.setPassword(hash);
            } else {
                resp.sendRedirect("/profile/edit");
                return;
            }
        }
        // update user info in database
        DaoFactory.getUsersDao().updateUser(user);
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/profile");

    }
}
