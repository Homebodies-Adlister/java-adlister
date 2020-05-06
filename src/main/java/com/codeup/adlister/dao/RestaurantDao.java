package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.Config;
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

    //Putting restaurants into list to show them all
    //createRestaurantFromResults method written on line 150
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


    //method for adding new restaurant to database
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

    //method for deleting a restaurant from database using id
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


    //method for editing a rest using the id to find the restaurant
    @Override
    public Restaurant updateRestaurant (Restaurant restaurant){
        String updateQuery = "UPDATE restaurant SET" +
                "title = ?," +
                "description = ?" +
                "rating = ?" +
                "mask = ?" +
                "gloves = ?" +
                "social_distancing = ?" +
                "dine_in = ?" +
                "take_out = ?" +
                "WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(updateQuery);
            stmt.setString(1, restaurant.getTitle());
            stmt.setString(2,restaurant.getDescription());
            stmt.setInt(3, restaurant.getRating());
            stmt.setBoolean(4, restaurant.hasMask());
            stmt.setBoolean(5, restaurant.hasGloves());
            stmt.setBoolean(6, restaurant.isSocialDistancing());
            stmt.setBoolean(7, restaurant.isDineIn());
            stmt.setBoolean(8, restaurant.isTakeOut());
            stmt.setLong(9, restaurant.getId());
        } catch (SQLException e){
            throw new RuntimeException("Error editing restaurant");
        }
        return restaurant;
    }

    //method for finding a restaurant in the data base using the id as a reference
    @Override
    public Restaurant findRestaurantById(long id){
        Restaurant returnRestaurant = new Restaurant();
        String query = String.format("SELECT * FROM restaurant WHERE id = %d", id);
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()){
                returnRestaurant.setId(id);
                returnRestaurant.setTitle(rs.getString("title"));
                returnRestaurant.setDescription(rs.getString("description"));
                returnRestaurant.setRating(rs.getInt("rating"));
                returnRestaurant.setHasMask(rs.getBoolean("mask"));
                returnRestaurant.setHasGloves(rs.getBoolean("gloves"));
                returnRestaurant.setDineIn(rs.getBoolean("dine_in"));
                returnRestaurant.setTakeOut(rs.getBoolean("take_out"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return returnRestaurant;
    }

    //method used in createRestaurantFromResults
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

    //using the extractRestaurant to make a new restaurant
    private List<Restaurant> createRestaurantFromResults(ResultSet rs) throws SQLException {
        List<Restaurant> restaurants = new ArrayList<>();
        while (rs.next()) {
            restaurants.add(extractRestaurant(rs));
        }
        return restaurants;
    }

}
