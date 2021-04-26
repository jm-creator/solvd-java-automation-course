package com.solvd.connectionPool.models;

import java.util.Date;

public class Payment extends BaseModel{

    private Date paymentDate;
    private double amount;
    private PaymentType type;
    private TransactionStatus status;
    private Order order;

    public Payment() {}

    public Payment(Date paymentDate, double amount, PaymentType type, TransactionStatus status, Order order) {
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.order = order;
    }

    public Payment(Long id, Date paymentDate, double amount) {
        super(id);
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.type = new PaymentType();
        this.status = new TransactionStatus();
        this.order = new Order();
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", type=" + type +
                ", status=" + status +
                ", order=" + order +
                '}';
    }
}
