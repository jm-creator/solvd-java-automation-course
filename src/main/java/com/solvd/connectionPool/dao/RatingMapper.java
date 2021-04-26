package com.solvd.connectionPool.dao;

import com.solvd.connectionPool.models.Order;
import com.solvd.connectionPool.models.Rating;

import java.util.List;

public interface RatingMapper extends IQuery<Rating> {
    List<Rating> getAllByRestaurantId(long id);
    List<Rating> getAllByMenuId(long id);

}
