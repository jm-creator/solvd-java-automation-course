package com.solvd.connectionPool.models;

import java.util.ArrayList;
import java.util.List;

public class Address extends BaseModel{

    private String address;
    private int zipCode;
    private City city;
    private List<Restaurant> restaurants;
    private List<Customer> customers;

    public Address() {}

    public Address(String address, int zipCode, City city) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.restaurants = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public Address(Long id, String address, int zipCode) {
        super(id);
        this.address = address;
        this.zipCode = zipCode;
        this.city = new City();
        this.restaurants = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", zipCode=" + zipCode +
                ", city=" + city +
                '}';
    }
}
