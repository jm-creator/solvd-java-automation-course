package com.solvd.connectionPool.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Customer extends BaseModel {
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("Address")
    private Address address;
    @XmlTransient
    private List<Order> orders;

    public Customer() {}

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.orders = new ArrayList<>();
    }

    public Customer(Long id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = new Address();
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


    @Override
    public String toString() {
        return "Customer{" +
                "id = "+ super.getId()+
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address = " + address +
                '}';
    }
}
