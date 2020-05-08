package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Restaurant;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AddRestaurantServlet", urlPatterns = "/addRestaurant")
public class AddRestaurantServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int userId = Integer.parseInt(request.getParameter("user_id"));
        String title = request.getParameter("restaurant-title");
        String description = request.getParameter("restaurantDescription");
        int rating = Integer.parseInt(request.getParameter("restaurant-rating"));
        boolean mask = Boolean.parseBoolean(request.getParameter("mask"));
        boolean gloves = Boolean.parseBoolean(request.getParameter("gloves"));
        boolean socialDistance = Boolean.parseBoolean(request.getParameter("social-distance"));
        boolean dineIn = Boolean.parseBoolean(request.getParameter("dine-in"));
        boolean takeOut = Boolean.parseBoolean(request.getParameter("take-out"));

        // validate input
        boolean inputHasErrors = title.isEmpty()
                || description.isEmpty();

        if (inputHasErrors) {
            response.sendRedirect("/profile");
        }
        //pass in parameters to new restaurant
        Restaurant restaurant = new Restaurant(userId, title, description, rating, mask, gloves, socialDistance, dineIn, takeOut);

        // create and save a new restaurant
        DaoFactory.getRestaurantDao().addRestaurant(restaurant);
    }



}
