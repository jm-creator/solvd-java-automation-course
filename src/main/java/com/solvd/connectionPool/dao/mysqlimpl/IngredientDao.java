package com.solvd.connectionPool.dao.mysqlimpl;

import com.solvd.connectionPool.dao.AbstractDao;
import com.solvd.connectionPool.dao.IngredientMapper;
import com.solvd.connectionPool.dbpool.ClosableEntity;
import com.solvd.connectionPool.models.Customer;
import com.solvd.connectionPool.models.Ingredient;
import com.solvd.connectionPool.models.MenuHasIngredients;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientDao extends AbstractDao implements IngredientMapper {

    private static final Logger LOGGER = Logger.getLogger(AddressDao.class);
    private static final String GET_ALL = "SELECT * FROM Ingredients";
    private static final String GET_BY_ID = "SELECT * FROM Ingredients WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Ingredients WHERE id = ?";
    private static final String UPDATE_BY_ID  = "UPDATE Ingredients SET ? = ? WHERE id = ?";

    @Override
    public Ingredient getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeIngredients(rs);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ingredient> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Ingredient> ingredients = new ArrayList<>();
            while (rs.next()) ingredients.add(initializeIngredients(rs));
            return ingredients;
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
    public Ingredient initializeIngredients(ResultSet rs) throws SQLException {
        return new Ingredient(rs.getLong("id"), rs.getString("name"),
                rs.getString("description"), rs.getDouble("price"));
    }
}
