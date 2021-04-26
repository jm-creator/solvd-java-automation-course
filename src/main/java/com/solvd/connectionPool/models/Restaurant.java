package com.solvd.connectionPool.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends BaseModel {
    private String name;
    private String description;
    private Address address;
    private List<Order> orders;
    private List<Rating> ratings;

    public Restaurant() {}

    public Restaurant(String name, String description, Address address, List<Order> orders, List<Rating> ratings) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.orders = orders;
        this.ratings = ratings;
    }

    public Restaurant(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
        this.address = new Address();
        this.orders = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", orders=" + orders +
                ", ratings=" + ratings +
                '}';
    }
}
