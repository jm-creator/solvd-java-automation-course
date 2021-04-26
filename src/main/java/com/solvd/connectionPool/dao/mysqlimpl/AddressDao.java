package com.solvd.connectionPool.dao.mysqlimpl;

import com.solvd.connectionPool.dao.AbstractDao;
import com.solvd.connectionPool.dao.AddressMapper;
import com.solvd.connectionPool.dbpool.ClosableEntity;
import com.solvd.connectionPool.models.Address;
import com.solvd.connectionPool.models.Customer;
import com.solvd.connectionPool.models.MenuHasIngredients;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDao extends AbstractDao implements AddressMapper {

    private static final Logger LOGGER = Logger.getLogger(AddressDao.class);
    private static final String GET_ALL = "SELECT * FROM Addresses";
    private static final String GET_BY_ID = "SELECT * FROM Addresses WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Addresses WHERE id = ?";
    private static final String UPDATE_BY_ID  = "UPDATE Addresses SET ? = ? WHERE id = ?";

    @Override
    public Address getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeAddress(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Address> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Address> addresses = new ArrayList<>();
            while (rs.next()) addresses.add(initializeAddress(rs));
            return addresses;
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

    public Address initializeAddress(ResultSet rs) throws SQLException {
        return new Address(rs.getLong("id"), rs.getString("address"),rs.getInt("zip_code"));
    }
}
