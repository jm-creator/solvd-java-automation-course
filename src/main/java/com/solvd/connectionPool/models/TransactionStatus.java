package com.solvd.connectionPool.models;

public class TransactionStatus extends BaseModel {
    private String name;

    public TransactionStatus() {}

    public TransactionStatus(String name) {
        this.name = name;
    }

    public TransactionStatus(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TransactionStatus{" +
                "name='" + name + '\'' +
                '}';
    }
}
