package com.example.model;

import java.io.Serializable;

public class Meal implements Serializable {
    private int Id;
    private int Image;
    private String name;
    private double rate;
    private int rateCount;
    private String address;
    private  String mealType;

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getRateCount() {
        return rateCount;
    }

    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Meal(int id, int image, String name, double rate, int rateCount, String address, String mealType) {
        Id = id;
        Image = image;
        this.name = name;
        this.rate = rate;
        this.rateCount = rateCount;
        this.address = address;
        this.mealType = mealType;
    }
}
