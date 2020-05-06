package com.codeup.adlister.dao;

import com.codeup.adlister.models.Restaurant;

import java.util.List;

public interface Restaurants {
    List<Restaurant> all();

    Long addRestaurant(Restaurant restaurant);

    void deleteRestaurantById(long id);

    Restaurant updateRestaurant (Restaurant restaurant);

    Restaurant findRestaurantById(long restaurantId);

}
