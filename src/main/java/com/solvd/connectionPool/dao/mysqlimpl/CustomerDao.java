package com.solvd.connectionPool.dao.mysqlimpl;

import com.solvd.connectionPool.dao.AbstractDao;
import com.solvd.connectionPool.dao.CustomerMapper;
import com.solvd.connectionPool.dbpool.ClosableEntity;
import com.solvd.connectionPool.models.Customer;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends AbstractDao implements CustomerMapper {

    private static final Logger LOGGER = Logger.getLogger(Customer.class);
    private static final String GET_ALL = "SELECT * FROM Customers";
    private static final String GET_BY_ID = "SELECT * FROM Customers WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Customers WHERE id = ?";
    private static final String UPDATE_BY_ID  = "UPDATE Customers SET ? = ? WHERE id = ?";

    @Override
    public Customer getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeCustomer(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Customer> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Customer> customers = new ArrayList<>();
            while (rs.next()) customers.add(initializeCustomer(rs));
            return customers;
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

    public Customer initializeCustomer(ResultSet rs) throws SQLException {
        return new Customer(rs.getLong("id"), rs.getString("name"),
                rs.getString("email"), rs.getString("password"));
    }
}
