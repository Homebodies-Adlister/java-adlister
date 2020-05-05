package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Restaurant;

import java.util.List;

public interface Restaurants {
    List<Restaurant> all();

    Long addRestaurant(Restaurant restaurant);

    Long deleteRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant (Restaurant restaurant);

    Long findRestaurantById(long restaurantId);

}
