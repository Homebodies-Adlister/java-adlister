package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Restaurant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.ViewRestaurantServlet", urlPatterns = "/myrestaurants")
public class ViewRestaurantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        String idStr = request.getParameter("id");
        Long id = Long.parseLong(idStr);

        Restaurant restaurant = DaoFactory.getRestaurantDao().findRestaurantById(id);

        List<Restaurant> myRestaurants = new ArrayList<>();
        myRestaurants.add(restaurant);
        request.setAttribute("Restaurants", myRestaurants);

        request.getRequestDispatcher("/WEB-INF/myrestaurants.jsp").forward(request, response);
    }
}
