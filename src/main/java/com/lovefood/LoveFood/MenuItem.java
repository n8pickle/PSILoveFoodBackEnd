package com.lovefood.LoveFood;

import java.awt.image.BufferedImage;

public class MenuItem {

    int itemId;
    double price;
    String food;
    String description;
    BufferedImage picture;

    public MenuItem(int itemId, double price, String food, String description, BufferedImage picture) {
        this.itemId = itemId;
        this.price = price;
        this.food = food;
        this.description = description;
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public int getItemId() {
        return itemId;
    }

    public String getFood() {
        return food;
    }

    public String getDescription() {
        return description;
    }

    public BufferedImage getPicture() {
        return picture;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(BufferedImage picture) {
        this.picture = picture;
    }
}
