package com.solvd.connectionPool.dao.mysqlimpl;

import com.solvd.connectionPool.dao.AbstractDao;
import com.solvd.connectionPool.dao.TransactionStatusMapper;
import com.solvd.connectionPool.dbpool.ClosableEntity;
import com.solvd.connectionPool.models.TransactionStatus;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionStatusDao extends AbstractDao implements TransactionStatusMapper {
    private static final Logger LOGGER = Logger.getLogger(AddressDao.class);
    private static final String GET_ALL = "SELECT * FROM TransactionStatus";
    private static final String GET_BY_ID = "SELECT * FROM TransactionStatus WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM TransactionStatus WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE TransactionStatus SET ? = ? WHERE id = ?";

    @Override
    public TransactionStatus getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeTransactionStatus(rs);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<TransactionStatus> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<TransactionStatus> transactionStatuses = new ArrayList<>();
            while (rs.next()) transactionStatuses.add(initializeTransactionStatus(rs));
            return transactionStatuses;
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

    public TransactionStatus initializeTransactionStatus(ResultSet rs) throws SQLException {
        return new TransactionStatus(rs.getLong("id"), rs.getString("name"));
    }
}
