package com.codeup.adlister.models;

public class Restaurant {
    private long id;
    private String title;
    private String description;
    private int rating;
    private boolean mask;
    private boolean gloves;
    private boolean socialDistancing;
    private boolean dineIn;
    private boolean takeIn;

    public Restaurant(){};

    public Restaurant(long id, String title, String description, int rating, boolean mask, boolean gloves, boolean socialDistancing, boolean dineIn, boolean takeIn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.mask = mask;
        this.gloves = gloves;
        this.socialDistancing = socialDistancing;
        this.dineIn = dineIn;
        this.takeIn = takeIn;
    }

    public Restaurant(String title, String description, int rating, boolean mask, boolean gloves, boolean socialDistancing, boolean dineIn, boolean takeIn) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.mask = mask;
        this.gloves = gloves;
        this.socialDistancing = socialDistancing;
        this.dineIn = dineIn;
        this.takeIn = takeIn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean hasMask() {
        return mask;
    }

    public void setHasMask(boolean mask) {
        this.mask = mask;
    }

    public boolean hasGloves() {
        return gloves;
    }

    public void setHasGloves(boolean gloves) {
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

    public boolean isTakeIn() {
        return takeIn;
    }

    public void setTakeIn(boolean takeIn) {
        this.takeIn = takeIn;
    }
}
