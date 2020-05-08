package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Retail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RetailServlet", urlPatterns = "/update")
public class RetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("src/main/webapp/WEB-INF/stores/updateStore.jsp").forward(request, response);
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("src/main/webapp/WEB-INF/stores/updateStore.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
//        int rating = request.getParameter();


        Retail retail = new Retail();
        DaoFactory.getRetailDao().insertRetail(retail);
        response.sendRedirect("/login");
    }


}


//        Retail retail = new Retail(
//
//                /* rs.getLong("id"),
//                rs.getString("title"),
//                rs.getString("description"),
//                rs.getInt("rating"),
//                rs.getBoolean("gloves"),
//                rs.getBoolean("masks"),
//                rs.getBoolean("curb_side"),
//                rs.getBoolean("social_distance"),
//                rs.getBoolean("in_store"),
//                rs.getBoolean("can_delete")*/
//
//                request.getParameter(),
//                request.getParameter("title"),
//                request.getParameter("description"),
//                request.getParameter("rating"),
//                request.getParameter("gloves"),
//                request.getParameter("masks"),
//                request.getParameter("curb_side"),
//                request.getParameter("social_distance"),
//                request.getParameter("in_store"),
//                request.getParameter("can_delete")


//    User user = (User) request.getSession().getAttribute("user");
//    Retail retail = new Retail(
//            user.getId(),
//            request.setAttribute("id", id)
//    );
//        DaoFactory.getRetailDao().insertRetail(retail);
//        response.sendRedirect("/login");
//}