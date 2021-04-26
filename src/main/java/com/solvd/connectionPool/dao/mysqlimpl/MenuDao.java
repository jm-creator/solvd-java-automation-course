package com.solvd.connectionPool.dao.mysqlimpl;

import com.solvd.connectionPool.dao.AbstractDao;
import com.solvd.connectionPool.dao.MenuMapper;
import com.solvd.connectionPool.dbpool.ClosableEntity;
import com.solvd.connectionPool.models.Customer;
import com.solvd.connectionPool.models.Menu;
import com.solvd.connectionPool.models.MenuHasIngredients;
import com.solvd.connectionPool.models.Order;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuDao extends AbstractDao implements MenuMapper {

    private static final Logger LOGGER = Logger.getLogger(AddressDao.class);
    private static final String GET_ALL = "SELECT * FROM Menu";
    private static final String GET_BY_ID = "SELECT * FROM Menu WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Menu WHERE id = ?";
    private static final String UPDATE_BY_ID  = "UPDATE Menu SET ? = ? WHERE id = ?";


    @Override
    public Menu getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeMenus(rs);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Menu> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Menu> menus = new ArrayList<>();
            while (rs.next()) menus.add(initializeMenus(rs));
            return menus;
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

    public Menu initializeMenus(ResultSet rs) throws SQLException {
        return new Menu(rs.getLong("id"), rs.getString("name"));
    }
}
