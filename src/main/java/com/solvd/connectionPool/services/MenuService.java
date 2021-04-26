package com.solvd.connectionPool.services;

import com.solvd.connectionPool.dao.*;
import com.solvd.connectionPool.dao.mysqlimpl.*;
import com.solvd.connectionPool.models.Menu;

import java.util.List;

public class MenuService {
    private MenuMapper menuDao;
    private RatingMapper ratingDao;
    private OrderMapper orderDao;
    private MenuHasIngredientsMapper menuHasIngredientsDao;
    private RestaurantMapper restaurantDao;

    public MenuService(RatingMapper ratingDao, OrderMapper orderDao, MenuHasIngredientsMapper menuHasIngredientsDao, RestaurantMapper restaurantDao) {
        this.ratingDao = ratingDao;
        this.orderDao = orderDao;
        this.menuHasIngredientsDao = menuHasIngredientsDao;
        this.restaurantDao = restaurantDao;
    }

    public MenuService() {
        this.ratingDao = new RatingDao();
        this.orderDao = new OrderDao();
        this.menuHasIngredientsDao = new MenuHasIngredientsDao();
        this.restaurantDao = new RestaurantDao();
    }

    public Menu getById(long id) {
        Menu menu = menuDao.getById(id);
        return menu;
    }

    public List<Menu> getAll() {
        List<Menu> menus = menuDao.getAll();
        menus.forEach(this::initializeMenu);
        return menus;
    }

    public void initializeMenu(Menu menu) {
        menu.setRatings(ratingDao.getAllByMenuId(menu.getId()));
        menu.setOrders(orderDao.getAllByMenuId(menu.getId()));
        menu.setMenuHasIngredients(menuHasIngredientsDao.getAllByMenuId(menu.getId()));
        menu.setRestaurant(restaurantDao.getById(menu.getId()));
    }

}
