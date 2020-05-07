package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Retail;
import com.codeup.adlister.util.Password;

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
        //gets the retail id
        String rId = request.getParameter("retailId");
        Long id = Long.parseLong(rId);

        //gets the title of the retail
        String retailTitle = request.getParameter("titles");
        //gets the description of the retail
        String retailDescription = request.getParameter("description");

        //gets weather or not the retail uses masks
        String useMask = (request.getParameter("masks"));
        boolean masks = usesMasks(useMask);

        //gets weather or not the retail uses gloves
        String useGloves = (request.getParameter("gloves"));
        boolean gloves = usesGloves(useGloves);

        //gets weather or not the retail practices social distancing
        String practiceSD = (request.getParameter("sd"));
        boolean socialDistance = implementsSD(practiceSD);

        //gets weather or not the retail has a curbside option
        String hasCurbside = (request.getParameter("cs"));
        boolean curbSide = curbSide(hasCurbside);

        //gets weather or not the retail allows shoppers in store
        String isInStore = (request.getParameter("is"));
        boolean inStore = inStoreShopping(isInStore);

        //gets the rating of the user for the retail
        String userRate = (request.getParameter("rating"));
        int rating = userRating(userRate);

        //creates a new retail object
        Retail ret = new Retail(retailTitle, retailDescription, masks, gloves, socialDistance, curbSide, inStore, rating);
        DaoFactory.getRetailDao().updateRetail(ret);
        response.sendRedirect("/profile");

        //Should find the retail by id to edit it
        DaoFactory.getRetailDao().findRetailById(id);
        if (id == null) {
            response.sendRedirect("/profile");
            return;
        }

    }

    //determines if the user pressed true or false the masks submission
    public static boolean usesMasks(String masks){
        boolean useMask = false;
           if (useMask == true) {
               useMask = Boolean.parseBoolean(masks);
           }
        return useMask;
    }

    //determines if the user pressed true or false on the gloves submission
    public static boolean usesGloves(String gloves){
        boolean useGloves = false;
        if (useGloves == true) {
            useGloves = Boolean.parseBoolean(gloves);
        }
        return useGloves;
    }

    //determines if the user pressed true or false on the social distance submission
    public static boolean implementsSD(String socialDistance){
        boolean socialD = false;
        if (socialD == true) {
            socialD = Boolean.parseBoolean(socialDistance);
        }
        return socialD;
    }

    //determines if the user pressed true or false on the curbside options submission
    public static boolean curbSide(String curbSide){
        boolean curbS = false;
        if (curbS == true) {
            curbS = Boolean.parseBoolean(curbSide);
        }
        return curbS;
    }

    //determines if the user pressed true or false on the in store shopping submission
    public static boolean inStoreShopping(String inStore){
        boolean inS = false;
        if (inS == true) {
            inS = Boolean.parseBoolean(inStore);
        }
        return inS;
    }

    //gets the users overall rating of the store
    public static int userRating(String rating){
        int rat = 0;
        try {
            if (rating.length() == 5){
                rat = Integer.parseInt(rating);
            }
        } catch (NumberFormatException nfe){
            throw new RuntimeException("Incorrect format");
        }
        return rat;
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