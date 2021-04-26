package com.solvd.connectionPool.dao;

import com.solvd.connectionPool.models.Customer;
import com.solvd.connectionPool.models.MenuHasIngredients;

import java.sql.Statement;
import java.util.List;

public interface IQuery<T> {
    T getById(long id);

    List<T> getAll();

    void deleteById(long id);

    void updateById(long id, String column, String value);

    void save(Statement query);
}
