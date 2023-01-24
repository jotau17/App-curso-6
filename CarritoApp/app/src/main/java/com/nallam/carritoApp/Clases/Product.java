package com.nallam.carritoApp.Clases;

public class Product {
    private String title;
    private double price;
    private int image;

    public Product(String title, double price, int image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}