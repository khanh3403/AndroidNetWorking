package com.example.asmagile.Obj;

import java.io.Serializable;

public class Categories implements Serializable {

    private String id;
    private String name;
    private String image;

    public Categories() {
    }

    public Categories(String name, String image) {
        this.name = name;
        this.image = image;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
