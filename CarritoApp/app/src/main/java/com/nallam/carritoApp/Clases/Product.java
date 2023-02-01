package com.nallam.carritoApp.Clases;

import android.net.Uri;

public class Product {
    private String title;
    private String price;
    private int image;
    private int Id;

    public Product(String title, String price, int image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }
    public Product(String title, String price, int image, int id) {
        this.title = title;
        this.price = price;
        this.image = image;
        this.Id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public Uri getImage() {
        return Uri.parse(String.valueOf(image));
    }

    public int getId() {
        return this.Id;
    }
}