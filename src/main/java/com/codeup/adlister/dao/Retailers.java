package com.codeup.adlister.dao;

import com.codeup.adlister.models.Retail;

import java.util.List;

public interface Retailers {
    //create list of all the Retail stores
    List<Retail> allRetail();
    //insert a new Retail store
    Long insertRetail(Retail retail);
    //Delete a retail store
    void deleteRetail(Retail retail);
    //Uodate retail
    Retail updateRetail(Retail retail);

    Retail findRetailById(long retailId);


//    //add a description to
//    String addRetailDescription(Retail retail);
//    //Add a title to the Retail store
//    String retailTitle(Retail retail);
}
