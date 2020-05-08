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

@WebServlet("/myrestaurants")
public class ViewRestaurantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);

        Restaurant restaurant = DaoFactory.getRestaurantDao().findRestaurantById(id);

        List<Restaurant> myRestaurants = new ArrayList<>();
        myRestaurants.add(restaurant);
        request.setAttribute("Restaurants", myRestaurants);
        request.getRequestDispatcher("/WEB-INF/stores/myrestaurants.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/stores/myrestaurants.jsp").forward(request, response);
    }
}
