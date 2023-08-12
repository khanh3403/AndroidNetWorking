package com.example.lab2.lab4.insert;

public class Prd {
    private String name,price,description;

    public Prd() {
    }

    public Prd(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desscription) {
        this.description = desscription;
    }
}
