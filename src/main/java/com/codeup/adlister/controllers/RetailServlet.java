package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Retail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RetailServlet", urlPatterns = "/retail")
public class RetailServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ads/")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Retail retail = new Retail(

                /* rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getInt("rating"),
                rs.getBoolean("gloves"),
                rs.getBoolean("masks"),
                rs.getBoolean("curb_side"),
                rs.getBoolean("social_distance"),
                rs.getBoolean("in_store"),
                rs.getBoolean("can_delete")*/

//                request.getParameter("id"),
//                request.getParameter("title"),
//                request.getParameter("description"),
//                request.getParameter("rating"),
//                request.getParameter("gloves"),
//                request.getParameter("masks"),
//                request.getParameter("curb_side"),
//                request.getParameter("social_distance"),
//                request.getParameter("in_store"),
//                request.getParameter("can_delete")


        );
        DaoFactory.getRetailDao().insertRetail(retail);
        response.sendRedirect("/ads");
    }

}
