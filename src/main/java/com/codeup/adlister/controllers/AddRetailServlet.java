package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Restaurant;
import com.codeup.adlister.models.Retail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AddRetailServlet", urlPatterns = "/addRetail")
public class AddRetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int userId = Integer.parseInt(request.getParameter("user_id"));
        String retailTitle = request.getParameter("shop-title");
        String retailDescription = request.getParameter("retailDescription");
        int retailRating = Integer.parseInt(request.getParameter("retail-rating"));
        boolean curbSide = Boolean.parseBoolean(request.getParameter("curb-side"));
        boolean inStore = Boolean.parseBoolean(request.getParameter("in-store"));
        boolean retailMask = Boolean.parseBoolean(request.getParameter("shop-mask"));
        boolean retailGloves = Boolean.parseBoolean(request.getParameter("shop-gloves"));
        boolean socialDistance = Boolean.parseBoolean(request.getParameter("shop-distance"));


        // validate input
        boolean inputHasErrors = retailTitle.isEmpty()
                || retailDescription.isEmpty();

        if (inputHasErrors) {
            response.sendRedirect("/profile");
        }
        //pass in parameters to new restaurant
        Retail retail = new Retail(userId, retailTitle, retailDescription, retailRating, retailMask, retailGloves, socialDistance, curbSide, inStore);

        // create and save a new restaurant
        DaoFactory.getRetailDao().insertRetail(retail);
    }


}