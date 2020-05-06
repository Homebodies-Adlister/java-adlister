package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Restaurant;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDao implements Restaurants{
    private Connection connection = null;

    public RestaurantDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),

                    config.getUserName(),

                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Restaurant> all(){
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("SELECT * FROM restaurant");
            ResultSet rs = stmt.executeQuery();
            return createRestaurantFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long addRestaurant(Restaurant restaurant){
        long newlyCreatedRestaurant = 0;
        String addRestaurantQuery = String.format("INSERT INTO restaurant (id, title, description, rating, mask, gloves, social_distancing, dine_in, take_out) VALUES ('%d, '%s', '%s', '%d', '%b', '%b', '%b', '%b', '%b')",
                restaurant.getId(),
                restaurant.getTitle(),
                restaurant.getDescription(),
                restaurant.getRating(),
                restaurant.hasMask(),
                restaurant.hasGloves(),
                restaurant.isSocialDistancing(),
                restaurant.isDineIn(),
                restaurant.isTakeOut()
        );
        return newlyCreatedRestaurant;
    }

    @Override
    public void deleteRestaurantById(long id){
        String deleteQuery = "DELETE FROM restaurant WHERE id = ?";
        try {
           PreparedStatement stmt = connection.prepareStatement(deleteQuery);
           stmt.setLong(1, id);
           boolean success = stmt.execute(String.valueOf(stmt));
            if (success){
                System.out.println("Restaurant has been deleted");
            } else {
                System.out.println("Check for syntax errors");
            }
        } catch (SQLException e){
            throw new RuntimeException("Error deleting restaurant", e);
        }
    }

    Restaurant updateRestaurant (Restaurant restaurant){

    }

    private Restaurant extractRestaurant(ResultSet rs) throws SQLException {
        return new Restaurant(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getInt("rating"),
                rs.getBoolean("mask"),
                rs.getBoolean("gloves"),
                rs.getBoolean("socialDistancing"),
                rs.getBoolean("dineIn"),
                rs.getBoolean("takeOut")
        );
    }

    private List<Restaurant> createRestaurantFromResults(ResultSet rs) throws SQLException {
        List<Restaurant> restaurants = new ArrayList<>();
        while (rs.next()) {
            restaurants.add(extractRestaurant(rs));
        }
        return restaurants;
    }

}
