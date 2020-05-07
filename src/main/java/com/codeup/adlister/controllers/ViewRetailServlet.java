package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Retail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.ViewRetailServlet", urlPatterns = "/mystores")
public class ViewRetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Long id = Long.parseLong(idStr);

        Retail retail = DaoFactory.getRetailDao().findRetailById(id);

        List<Retail> myStores = new ArrayList<>();
        myStores.add(retail);
        request.setAttribute("Restaurants", myStores);

        request.getRequestDispatcher("/WEB-INF/myStores.jsp").forward(request, response);
    }
}
