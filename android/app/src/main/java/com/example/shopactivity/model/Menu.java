package com.example.shopactivity.model;

/**
 * Created by Choccochip on 26/9/2560.
 */

public class Menu {
    private int image;
    private String name;
    private String price;
    private String point;

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name  = name;
    }

    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price  = price;
    }

    public String getPoint(){
        return point;
    }
    public void setPoint(String point){
        this.point  = price;
    }
}
