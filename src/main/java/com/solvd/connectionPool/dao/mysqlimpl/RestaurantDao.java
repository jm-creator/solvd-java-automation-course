package com.solvd.connectionPool.dao.mysqlimpl;

import com.solvd.connectionPool.dao.AbstractDao;
import com.solvd.connectionPool.dao.RestaurantMapper;
import com.solvd.connectionPool.dbpool.ClosableEntity;
import com.solvd.connectionPool.models.Restaurant;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDao extends AbstractDao implements RestaurantMapper {

    private static final Logger LOGGER = Logger.getLogger(AddressDao.class);
    private static final String GET_ALL = "SELECT * FROM Restaurants";
    private static final String GET_BY_ID = "SELECT * FROM Restaurants WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Restaurants WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE Restaurants SET ? = ? WHERE id = ?";

    @Override
    public Restaurant getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeRestaurants(rs);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Restaurant> restaurants = new ArrayList<>();
            while (rs.next()) restaurants.add(initializeRestaurants(rs));
            return restaurants;
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

    public Restaurant initializeRestaurants(ResultSet rs) throws SQLException {
        return new Restaurant(rs.getLong("id"), rs.getString("name"), rs.getString("description"));
    }
}