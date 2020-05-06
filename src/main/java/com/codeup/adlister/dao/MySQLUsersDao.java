package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.User;
import com.codeup.adlister.controllers.Config;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    //Sets up DB connection
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            // Sets up our db driver, and make a connection
            DriverManager.registerDriver(new Driver());
            //Gets a connection object
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }// now we are connected to db
    }

//method for getting a user
    @Override
    public User findByUsername(String username) {
        PreparedStatement stmt;
        User user = null;
        // accounts for SQL Exception that needs to be handled
        try {
            //selects all users with the username passed in the parameter
            String sql = "SELECT * FROM users WHERE username = ?;";
            //puts string into prepare statement
            stmt = connection.prepareStatement(sql);
            //sets question mark as username parameter passed into method
            stmt.setString(1, username);
            //gives result from querying database in users
            ResultSet rs = stmt.executeQuery();
            //extractUser method defined below
            user = extractUser(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
        return user;
    }

    @Override
    public Long addUser(User user) {
        long newlyCreatedUserId = 0;
        try {
            //inserts sql command into prepared statement
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO users(username, email, password, zip) VALUES (?, ?, ?, ?);");
            //sets the username, email, pass and zip for new user
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setInt(3, user.getZip());
            //returns int representing number of rows affected by sql statement
            stmt.executeUpdate();
            //*****************************************
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                //saves mysql row id to variable
                newlyCreatedUserId = rs.getLong(1);
            }
            //checks if id was returned, or if new row is still at default of 0
            if(newlyCreatedUserId != 0){
                user.setId(newlyCreatedUserId);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding a user", e);
        }
        //returns new user's id
        return newlyCreatedUserId;
    }

    @Override
    //returning void because we are deleting
    public void deleteUser(long id) {
        // id passed in is the id of the row we want to delete from db user table
        String query = String.format("DELETE FROM users WHERE id = (?)");
        try {
            //ads sql query to preapared statement
            PreparedStatement stmt = connection.prepareStatement(query);
            //gets id from parameter and puts it into query
            stmt.setLong(1, id);
            //returns int representing number of rows affected by statement
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting user", e);
        }
    }

    @Override
    public User updateUser(User user) {
        User updated = new User();
        //sql statement to update the user for given id
        String updateQuery = "UPDATE users SET " +
                "username = ?," +
                "email = ?," +
                "password = ?," +
                "zip = ? " +
                "WHERE ID = ?;";
        try {
            //sql statement passed into prepared statement for protection/security
            PreparedStatement stmt = connection.prepareStatement(updateQuery);
            //inserts passed parameters into designated pieces of user object
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getUsername());
            stmt.setString(3,user.getPassword());
            stmt.setInt(4,user.getZip());
            stmt.setLong(5, user.getId());
            //executes update sql code
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating user", e);
        }
        //returns updated user
        return updated;
    }

    private User extractUser(ResultSet rs) throws SQLException {
        //if user does not exist returns null
        if (! rs.next()) {
            return null;
        }
        //if user exists grabs user object
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getInt("zip")
        );
    }

}
