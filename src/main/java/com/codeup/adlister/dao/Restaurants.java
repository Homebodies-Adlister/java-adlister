package com.codeup.adlister.dao;

import com.codeup.adlister.models.Restaurant;
import com.codeup.adlister.models.Retail;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Restaurants {
    List<Restaurant> all();

    Long addRestaurant(Restaurant restaurant);

    void deleteRestaurantById(long id);

    Restaurant updateRestaurant (Restaurant restaurant);

    Restaurant findRestaurantById(int restaurantId);

    List<Restaurant> findRestaurantByUsername (User user);

}
