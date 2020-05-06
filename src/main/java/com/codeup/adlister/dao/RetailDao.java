package com.codeup.adlister.dao;
import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Retail;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetailDao implements Retailers {

    private Connection connection = null;

    //This is the constructor for a new Retail object
    public RetailDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    //??Extracts information the database retail??
    private Retail extractRetail(ResultSet rs) throws SQLException {
        return new Retail(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getInt("rating"),
                rs.getBoolean("gloves"),
                rs.getBoolean("masks"),
                rs.getBoolean("curb_side"),
                rs.getBoolean("social_distance"),
                rs.getBoolean("in_store"),
                rs.getBoolean("can_delete")
        );
    }

    //this will generate a new list of restaurants
    private List<Retail> createRetailFromResults(ResultSet rs) throws SQLException {
        List<Retail> retail = new ArrayList<>();
        while (rs.next()) {
            retail.add(extractRetail(rs));
        }
        return retail;
    }


    //This is what will list all the retail store on the jsp page.
    @Override
    public List<Retail> allRetail() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM retail");
            ResultSet rs = stmt.executeQuery();
            return createRetailFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    //this is what will add a Retail Store to the retail database table.
    @Override
    public Long insertRetail(Retail retail) {
        try {
            String insertQuery = "INSERT INTO retail(id, title, description, rating, gloves, masks, curb_side, social_distance, in_store) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, retail.getUserId());
            stmt.setString(2, retail.getRetailTitle());
            stmt.setString(3, retail.getRetailDescription());
            stmt.setInt(4, retail.getRating());
            stmt.setBoolean(5, retail.isGloves());
            stmt.setBoolean(6, retail.isMasks());
            stmt.setBoolean(7, retail.isCurbSide());
            stmt.setBoolean(8, retail.isSocialDistance());
            stmt.setBoolean(9, retail.isInStore());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error Creating Retail Store.", e);
        }
    }

    //this is deleting the this is deleting the retail store by it's id.
    @Override
    public void deleteRetail(Retail retail) {
        try {
            String insertQuery = "DELETE FROM retail WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, retail.getId());
            stmt.executeUpdate();

            boolean success = stmt.execute(insertQuery);
            if(success){
                System.out.println("Retail Store added");
            } else {
                System.out.println("Did not add retail store");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error Deleting Retail Store.", e);
        }
    }

}

