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
        // Get user info from the session
        User user = (User) request.getSession().getAttribute("user");
       //try creating this restaurant
        try {
            //got object from Restaurant.java aka Restaurant bean
            Restaurant restaurant = new Restaurant(
                    user.getId(),
//                    Integer.parseInt(request.getParameter("user_id")),
                    request.getParameter("restaurant-title"),
                    request.getParameter("restaurantDescription"),
                    Integer.parseInt(request.getParameter("restaurant-rating")),
                    Boolean.parseBoolean(request.getParameter("mask")),
                    Boolean.parseBoolean(request.getParameter("gloves")),
                    Boolean.parseBoolean(request.getParameter("social-distance")),
                    Boolean.parseBoolean(request.getParameter("dine-in")),
                    Boolean.parseBoolean(request.getParameter("take-out"))
            );
            DaoFactory.getRestaurantDao().addRestaurant(restaurant);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/profile");

        String title = request.getParameter("restaurant-title");
        String description = request.getParameter("restaurantDescription");

        // validate input
//        boolean inputHasErrors = title.isEmpty()
//                || description.isEmpty();
//
//        if (inputHasErrors) {
//            response.sendRedirect("/profile");
//        }

        // create and save a new restaurant
    }



}
