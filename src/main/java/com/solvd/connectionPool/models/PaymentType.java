package com.solvd.connectionPool.models;

public class PaymentType extends BaseModel {
    private String name;
    private String description;

    public PaymentType() {}

    public PaymentType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PaymentType(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "PaymentType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
