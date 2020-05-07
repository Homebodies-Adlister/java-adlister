package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StoresIndexServlet", urlPatterns = "/whatsopen")
public class StoresIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            request.setAttribute("restaurants", DaoFactory.getRestaurantDao().all());
            request.setAttribute("retailers", DaoFactory.getRetailDao().allRetail());
            request.getRequestDispatcher("/WEB-INF/stores/index.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
