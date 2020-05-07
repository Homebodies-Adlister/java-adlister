package com.codeup.adlister.models;

public class Retail {
    private long userId;
    private long id;
    public String retailTitle;
    public String retailDescription;
    public int rating;
    public boolean gloves;
    public boolean masks;
    public boolean curbSide;
    public boolean socialDistance;
    public boolean inStore;

    public Retail(){}

    public Retail(long userId, String retailTitle, String retailDescription, int rating, boolean curbSide, boolean socialDistance, boolean inStore, boolean masks, boolean gloves){
        this.userId = userId;
        this.retailTitle = retailTitle;
        this.retailDescription = retailDescription;
        this.rating = rating;
        this.curbSide = curbSide;
        this.socialDistance = socialDistance;
        this.inStore = inStore;
        this.masks = masks;
        this.gloves = gloves;
    }

    public Retail(long id, long userId, String retailTitle, String retailDescription, int rating, boolean curbSide, boolean socialDistance, boolean inStore, boolean masks, boolean gloves){
        this.id = id;
        this.userId = userId;
        this.retailTitle = retailTitle;
        this.retailDescription = retailDescription;
        this.rating = rating;
        this.curbSide = curbSide;
        this.socialDistance = socialDistance;
        this.inStore = inStore;
        this.masks = masks;
        this.gloves = gloves;
    }

    public Retail(String title, String description, boolean useMask, boolean useGloves, boolean practiceSD, boolean hasCurbside, boolean isInStore) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRetailTitle() {
        return retailTitle;
    }

    public void setRetailTitle(String retailTitle) {
        this.retailTitle = retailTitle;
    }

    public String getRetailDescription() {
        return retailDescription;
    }

    public void setRetailDescription(String retailDescription) {
        this.retailDescription = retailDescription;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isCurbSide() {
        return curbSide;
    }

    public void setCurbSide(boolean curbSide) {
        this.curbSide = curbSide;
    }

    public boolean isSocialDistance() {
        return socialDistance;
    }

    public void setSocialDistance(boolean socialDistance) {
        this.socialDistance = socialDistance;
    }

    public boolean isInStore() {
        return inStore;
    }

    public void setInStore(boolean inStore) {
        this.inStore = inStore;
    }

    public boolean isGloves() {
        return gloves;
    }

    public void setGloves(boolean gloves) {
        this.gloves = gloves;
    }

    public boolean isMasks() {
        return masks;
    }

    public void setMasks(boolean masks) {
        this.masks = masks;
    }

}
