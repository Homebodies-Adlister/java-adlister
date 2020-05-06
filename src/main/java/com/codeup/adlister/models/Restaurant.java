package com.codeup.adlister.models;

public class Restaurant {
    private long id;
    private long user_id;
    private String title;
    private String description;
    private int rating;
    private boolean mask;
    private boolean gloves;
    private boolean socialDistancing;
    private boolean dineIn;
    private boolean takeOut;

    public Restaurant(){};

    public Restaurant(long id, long user_id, String title, String description, int rating, boolean mask, boolean gloves, boolean socialDistancing, boolean dineIn, boolean takeIn) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.mask = mask;
        this.gloves = gloves;
        this.socialDistancing = socialDistancing;
        this.dineIn = dineIn;
        this.takeOut = takeOut;
    }

    public Restaurant(long user_id, String title, String description, int rating, boolean mask, boolean gloves, boolean socialDistancing, boolean dineIn, boolean takeIn) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.mask = mask;
        this.gloves = gloves;
        this.socialDistancing = socialDistancing;
        this.dineIn = dineIn;
        this.takeOut = takeOut;
    }

    public long getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isMask() {
        return mask;
    }

    public void setMask(boolean mask) {
        this.mask = mask;
    }

    public boolean isGloves() {
        return gloves;
    }

    public void setGloves(boolean gloves) {
        this.gloves = gloves;
    }

    public boolean isSocialDistancing() {
        return socialDistancing;
    }

    public void setSocialDistancing(boolean socialDistancing) {
        this.socialDistancing = socialDistancing;
    }

    public boolean isDineIn() {
        return dineIn;
    }

    public void setDineIn(boolean dineIn) {
        this.dineIn = dineIn;
    }

    public boolean isTakeOut() {
        return takeOut;
    }

    public void setTakeOut(boolean takeOut) {
        this.takeOut = takeOut;
    }
}
