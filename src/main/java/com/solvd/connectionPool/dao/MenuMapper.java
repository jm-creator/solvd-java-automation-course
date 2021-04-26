package com.solvd.connectionPool.dao;

import com.solvd.connectionPool.models.Menu;

public interface MenuMapper extends IQuery<Menu>{
    Menu getByRestaurantId(long id);
}
