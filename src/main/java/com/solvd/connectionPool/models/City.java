package com.solvd.connectionPool.models;

import java.util.ArrayList;
import java.util.List;

public class City extends BaseModel {
    private String name;
    private List<Address> addresses;

    public City() {}

    public City(String name) {
        this.name = name;
        this.addresses = new ArrayList<>();
    }

    public City(Long id, String name) {
        super(id);
        this.name = name;
        this.addresses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
