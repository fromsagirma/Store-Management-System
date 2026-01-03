package com.store.model;

public class Product {

    private int id;
    private String name;
    private double price;
    private int quantity;
    private int sold;   


    public Product() {
    }


    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sold = 0;
    }


    public Product(int id, String name, double price, int quantity, int sold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sold = sold;
    }

    // ✅ GETTERS
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public int getSold() { return sold; }

    // ✅ SETTERS 
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setSold(int sold) { this.sold = sold; }
}
