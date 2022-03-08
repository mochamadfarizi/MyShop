package org.online.myshopfirebase.model;

public class Product {
    public String price;
    public String key;
    public String name;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Product (String nama ,String harga){
        name =nama;
        price =harga;
    }

}
