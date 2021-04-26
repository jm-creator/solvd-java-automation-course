package com.solvd.connectionPool.dao.mysqlimpl;

import com.solvd.connectionPool.dao.AbstractDao;
import com.solvd.connectionPool.dao.PaymentMapper;
import com.solvd.connectionPool.dbpool.ClosableEntity;
import com.solvd.connectionPool.models.Payment;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao extends AbstractDao implements PaymentMapper {
    private static final Logger LOGGER = Logger.getLogger(AddressDao.class);
    private static final String GET_ALL = "SELECT * FROM Payments";
    private static final String GET_BY_ID = "SELECT * FROM Payments WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM Payments WHERE id = ?";
    private static final String UPDATE_BY_ID  = "UPDATE Payments SET ? = ? WHERE id = ?";

    @Override
    public Payment getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializePayments(rs);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Payment> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionPool().getConnection())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Payment> payments = new ArrayList<>();
            while (rs.next()) payments.add(initializePayments(rs));
            return payments;
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

    public Payment initializePayments(ResultSet rs) throws SQLException {
        return new Payment(rs.getLong("id"), rs.getDate("paymentDate"), rs.getDouble("amount"));
    }
}
