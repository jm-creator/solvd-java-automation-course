package com.solvd.connectionPool.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends BaseModel {
    private String name;
    private String email;
    private String password;
    private Address address;
    private List<Rating> ratings;
    private List<Order> orders;

    public Customer() {}

    public Customer(String name, String email, String password, Address address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.ratings = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public Customer(Long id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = new Address();
        this.ratings = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }
}
