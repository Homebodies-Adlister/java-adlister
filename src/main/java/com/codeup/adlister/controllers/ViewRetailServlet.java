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

@WebServlet(urlPatterns = "/mystores")
public class ViewRetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
//            return;
//        }
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//
//        Retail retail = DaoFactory.getRetailDao().findRetailById(id);
//
//        List<Retail> myStores = new ArrayList<>();
//        myStores.add(retail);
//        request.setAttribute("Stores", myStores);
//        request.getRequestDispatcher("/WEB-INF/stores/mystores.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.getRequestDispatcher("/WEB-INF/stores/mystores.jsp").forward(request, response);

        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr) + 1;

        Retail retail = DaoFactory.getRetailDao().findRetailById(id);

        List<Retail> myStores = new ArrayList<>();
        myStores.add(retail);
        request.setAttribute("Stores", myStores);
        request.getRequestDispatcher("/WEB-INF/stores/mystores.jsp").forward(request, response);
    }
}
