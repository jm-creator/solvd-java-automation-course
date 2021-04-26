package com.solvd.connectionPool.dao.mysqlimpl;

import com.solvd.connectionPool.dao.AbstractDao;
import com.solvd.connectionPool.dao.OrderMapper;
import com.solvd.connectionPool.dbpool.ClosableEntity;
import com.solvd.connectionPool.models.Order;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends AbstractDao implements OrderMapper {
    private static final Logger LOGGER = Logger.getLogger(AddressDao.class);
    private static final String GET_ALL = "SELECT * FROM Orders";
    private static final String GET_BY_ID = "SELECT * FROM Orders WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Orders WHERE id = ?";
    private static final String UPDATE_BY_ID  = "UPDATE Orders SET ? = ? WHERE id = ?";
    private static final String GET_ALL_BY_RESTAURANT_ID = "SELECT * FROM Orders WHERE restaurant_id = ?";
    private static final String GET_ALL_BY_MENU_ID = "SELECT * FROM Orders WHERE Menu_id = ?";

    @Override
    public Order getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeOrders(rs);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Order>  orders = new ArrayList<>();
            while (rs.next()) orders.add(initializeOrders(rs));
            return orders;
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

    public Order initializeOrders(ResultSet rs) throws SQLException {
        return new Order(rs.getLong("id"), rs.getDouble("amount"));
    }

    @Override
    public List<Order> getAllByRestaurantId(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL_BY_RESTAURANT_ID, id);
            List<Order> orders = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) orders.add(initializeOrders(rs));
                return orders;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Order> getAllByMenuId(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL_BY_MENU_ID, id);
            List<Order> orders = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) orders.add(initializeOrders(rs));
                return orders;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }
}