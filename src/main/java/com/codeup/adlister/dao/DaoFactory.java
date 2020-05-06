package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Retailers retailDao;
    private static Restaurants restaurantDao;
    private static Config config = new Config();

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Retailers getRetailDao(){
        if (retailDao == null) {
            retailDao = new RetailDao(config);
        }
        return retailDao;
    }

    public static Restaurants getRestaurantDao(){
        if (restaurantDao == null) {
            restaurantDao = new RestaurantDao(config);
        }
        return restaurantDao;
    }

    public static Ads getAdsDao(){
        if (adsDao == null){
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

}
