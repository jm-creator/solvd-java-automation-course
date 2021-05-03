package com.solvd.connectionPool.services;

import com.solvd.connectionPool.dao.OrderMapper;
import com.solvd.connectionPool.dao.RatingMapper;
import com.solvd.connectionPool.dao.RestaurantMapper;
import com.solvd.connectionPool.dao.mysqlimpl.OrderDao;
import com.solvd.connectionPool.dao.mysqlimpl.RatingDao;
import com.solvd.connectionPool.models.Restaurant;

import java.util.List;

public class RestaurantService {
    private RestaurantMapper restaurantDao;
    private OrderMapper orderDao;
    private RatingMapper ratingDao;


    public RestaurantService(OrderMapper orderDao, RatingMapper ratingDao) {
        this.orderDao = orderDao;
        this.ratingDao = ratingDao;

    }

    public RestaurantService() {
        this.orderDao = new OrderDao();
        this.ratingDao = new RatingDao();
    }

    public Restaurant getById(long id) {
        Restaurant restaurant = restaurantDao.getById(id);
        restaurant.setRatings(ratingDao.getAllByRestaurantId(restaurant.getId()));
        return restaurant;
    }

    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = restaurantDao.getAll();
        restaurants.forEach(this::initializeRestaurant);
        return restaurants;
    }

    public void initializeRestaurant(Restaurant restaurant) {
        restaurant.setRatings(ratingDao.getAllByRestaurantId(restaurant.getId()));
    }

    public RestaurantMapper getRestaurantDao() {
        return restaurantDao;
    }

    public void setRestaurantDao(RestaurantMapper restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public OrderMapper getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderMapper orderDao) {
        this.orderDao = orderDao;
    }

    public RatingMapper getRatingDao() {
        return ratingDao;
    }

    public void setRatingDao(RatingMapper ratingDao) {
        this.ratingDao = ratingDao;
    }
}
