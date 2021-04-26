package com.solvd.connectionPool.dao;

import com.solvd.connectionPool.models.Order;

import java.util.List;

public interface OrderMapper extends IQuery<Order>{
    List<Order> getAllByRestaurantId(long id);
    List<Order> getAllByMenuId(long id);
}
