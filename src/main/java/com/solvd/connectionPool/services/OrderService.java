package com.solvd.connectionPool.services;

import com.solvd.connectionPool.dao.*;
import com.solvd.connectionPool.dao.mysqlimpl.*;
import com.solvd.connectionPool.models.Order;

import java.util.List;

public class OrderService {

    private OrderMapper orderDao;
    private PaymentMapper paymentDao;
    private TransactionStatusMapper transactionStatusDao;

    public OrderService(OrderMapper orderDao, TransactionStatusMapper transactionStatusDao, PaymentMapper paymentDao) {
        this.orderDao = orderDao;
        this.paymentDao = paymentDao;
        this.transactionStatusDao = transactionStatusDao;

    }

    public OrderService() {
        this.orderDao = new OrderDao();
        this.paymentDao = new PaymentDao();
        this.transactionStatusDao = new TransactionStatusDao();
    }

    public Order getById(long id) {
        Order order = orderDao.getById(id);
        return order;
    }

    public List<Order> getAllById() {
        List<Order> orders = orderDao.getAll();
        return orders;
    }

    public OrderMapper getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderMapper orderDao) {
        this.orderDao = orderDao;
    }


    public TransactionStatusMapper getTransactionStatusDao() {
        return transactionStatusDao;
    }

    public void setTransactionStatusDao(TransactionStatusMapper transactionStatusDao) {
        this.transactionStatusDao = transactionStatusDao;
    }
}
