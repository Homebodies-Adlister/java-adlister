package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Restaurant;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-restaurant")
public class RestaurantServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/updateRestaurant.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //gets the restaurant id
        String rId = request.getParameter("id");
        Long id = Long.parseLong(rId);

        //gets the title of the restaurant
        String restaurantTitle = request.getParameter("title");
        //gets the description of the restaurant
        String restaurantDescription = request.getParameter("description");

        //gets the rating of the user for the restaurant
        String userRate = (request.getParameter("rating"));
        int rating = userRating(userRate);

        //gets weather or not the restaurant uses masks
        String useMask = (request.getParameter("mask"));
        boolean masks = usesMasks(useMask);

        //gets weather or not the restaurant uses gloves
        String useGloves = (request.getParameter("gloves"));
        boolean gloves = usesGloves(useGloves);

        //gets weather or not the restaurant practices social distancing
        String practiceSD = (request.getParameter("sd"));
        boolean socialDistance = implementsSD(practiceSD);

        //gets weather or not the restaurant allows shoppers in store
        String isDineIn = (request.getParameter("di"));
        boolean dineIn = inStoreShopping(isDineIn);

        //gets weather or not the restaurant has a curbside option
        String hasCurbside = (request.getParameter("cs"));
        boolean curbSide = curbSide(hasCurbside);



        //creates a new restaurant object
        Restaurant ret = new Restaurant(id, restaurantTitle, restaurantDescription, rating, masks, gloves, socialDistance, dineIn, curbSide);
        DaoFactory.getRestaurantDao().updateRestaurant(ret);
        response.sendRedirect("/profile");

        //Should find the restaurant by id to edit it
        DaoFactory.getRestaurantDao().findRestaurantById(id);
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