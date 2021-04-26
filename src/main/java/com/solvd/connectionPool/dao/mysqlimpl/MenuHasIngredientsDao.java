package com.solvd.connectionPool.dao.mysqlimpl;

import com.solvd.connectionPool.dao.AbstractDao;
import com.solvd.connectionPool.dao.MenuHasIngredientsMapper;
import com.solvd.connectionPool.dbpool.ClosableEntity;
import com.solvd.connectionPool.models.MenuHasIngredients;
import com.solvd.connectionPool.models.Order;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuHasIngredientsDao extends AbstractDao implements MenuHasIngredientsMapper {
    private static final Logger LOGGER = Logger.getLogger(AddressDao.class);
    private static final String GET_ALL = "SELECT * FROM Menu_has_Ingredients";
    private static final String GET_BY_ID = "SELECT * FROM Menu_has_Ingredients WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Menu_has_Ingredients WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE Menu_has_Ingredients SET ? = ? WHERE id = ?";
    private static final String GET_ALL_MENU_HAS_INGREDIENTS_ID = "SELECT * FROM Menu_has_Ingredients WHERE restaurant_id = ?";
    @Override
    public MenuHasIngredients getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeMenuHasIngredients(rs);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<MenuHasIngredients> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<MenuHasIngredients> menuHasIngredients = new ArrayList<>();
            while (rs.next()) menuHasIngredients.add(initializeMenuHasIngredients(rs));
            return menuHasIngredients;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ce.executeDelete(DELETE_BY_ID, id);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void updateById(long id, String column, String value) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ce.executeUpdate(UPDATE_BY_ID, id, column, value);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void save(Statement query) {

    }

    public MenuHasIngredients initializeMenuHasIngredients(ResultSet rs) throws SQLException {
        return new MenuHasIngredients(rs.getLong("id"), rs.getInt("quantity"));
    }


    @Override
    public List<MenuHasIngredients> getAllByMenuId(Long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL_MENU_HAS_INGREDIENTS_ID, id);
            List<MenuHasIngredients> menuHasIngredients = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) menuHasIngredients.add(initializeMenuHasIngredients(rs));
                return menuHasIngredients;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }
}