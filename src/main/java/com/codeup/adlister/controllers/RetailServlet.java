package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Retail;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

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
        String title = request.getParameter("titles");
        String description = request.getParameter("description");

        String masks = (request.getParameter("masks"));
        boolean useMask = Boolean.parseBoolean(masks);

        String gloves = (request.getParameter("gloves"));
        boolean useGloves = Boolean.parseBoolean(gloves);

        String socialDistancing = (request.getParameter("sd"));
        boolean practiceSD = Boolean.parseBoolean(socialDistancing);

        String curbSide = (request.getParameter("cs"));
        boolean hasCurbside = Boolean.parseBoolean(curbSide);

        String inStore = (request.getParameter("is"));
        boolean isInStore = Boolean.parseBoolean(inStore);

        Retail ret = new Retail(title, description, useMask, useGloves, practiceSD, hasCurbside, isInStore);
        DaoFactory.getRetailDao().updateRetail(ret);

    }

    public boolean usesMasks(boolean masks){
//        boolean usesMask = false;
//        if (usesMask == true) {
//            usesMask;
//        }
//        return masks;
        return false;
    }

    public boolean usesGloves(boolean gloves){
        boolean useGloves = false;
        if (useGloves == true) {
            return useGloves;
        }
        return gloves;
    }


}




//        Retail retail = new Retail();
//        retail.setRetailTitle("title");
//        retail.setRetailDescription("description");
//        retail.setRating(1);
//        retail.setGloves(false);
//        retail.setMasks(false);

//        request.getAttribute(retail.getRetailTitle());
//        request.getAttribute(retail.getRetailDescription());
//        request.getAttribute(retail.getRating());

//        DaoFactory.getRetailDao().insertRetail(retail);
//        response.sendRedirect("/");


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