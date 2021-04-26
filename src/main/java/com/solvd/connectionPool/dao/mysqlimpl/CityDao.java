package com.solvd.connectionPool.dao.mysqlimpl;

import com.solvd.connectionPool.dao.AbstractDao;
import com.solvd.connectionPool.dao.CityMapper;
import com.solvd.connectionPool.dbpool.ClosableEntity;
import com.solvd.connectionPool.models.City;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDao extends AbstractDao implements CityMapper {

    private static final Logger LOGGER = Logger.getLogger(AddressDao.class);
    private static final String GET_ALL = "SELECT * FROM Cities";
    private static final String GET_BY_ID = "SELECT * FROM Cities WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Cities WHERE id = ?";
    private static final String UPDATE_BY_ID  = "UPDATE Cities SET ? = ? WHERE id = ?";

    @Override
    public City getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeCities(rs);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<City> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<City> cities = new ArrayList<>();
            while (rs.next()) cities.add(initializeCities(rs));
            return cities;
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
    public City initializeCities(ResultSet rs) throws SQLException {
        return new City(rs.getLong("id"), rs.getString("name"));
    }
}
