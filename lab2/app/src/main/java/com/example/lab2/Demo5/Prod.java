package com.example.lab2.Demo5;

public class Prod {
    private String pid,name,price,des;

    public Prod() {
    }

    public Prod(String pid, String name, String price, String des) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.des = des;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
