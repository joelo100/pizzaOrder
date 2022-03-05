package com.joe.pizzaorderservice.models;

import javax.persistence.*;
@Entity
@Table(name = "PizzaOrder")

public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;
    public PizzaOrder() {
    }

    public PizzaOrder(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PizzaOrder [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
