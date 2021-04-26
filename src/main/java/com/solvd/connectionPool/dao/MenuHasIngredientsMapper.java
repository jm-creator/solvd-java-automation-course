package com.solvd.connectionPool.dao;

import com.solvd.connectionPool.models.MenuHasIngredients;

import java.util.List;

public interface MenuHasIngredientsMapper extends IQuery<MenuHasIngredients>{
    List<MenuHasIngredients> getAllByMenuId(Long id);
}
