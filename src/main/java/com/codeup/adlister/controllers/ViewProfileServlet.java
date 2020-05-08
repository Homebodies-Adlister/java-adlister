package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Restaurant;
import com.codeup.adlister.models.Retail;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Restaurant> restList = DaoFactory.getRestaurantDao().findRestaurantByUsername(user);
        List<Retail> retList = DaoFactory.getRetailDao().findRetailByUsername(user);

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        if (!(restList == null)){
            request.setAttribute("restaurant",restList);
        }

        if (!(retList == null)) {
            request.setAttribute("retail",retList);
        }
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

}
