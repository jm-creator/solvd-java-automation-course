package com.solvd.connectionPool.dbpool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ClosableEntity implements AutoCloseable{

    private static final Logger LOGGER = Logger.getLogger(ClosableEntity.class);
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement statement;

    public ClosableEntity(Connection connection) {
        this.connection = connection;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        LOGGER.info("Executing query: " + query);
        resultSet = connection.prepareStatement(query).executeQuery();
        return resultSet;
    }

    public ResultSet executeQuery(String query, long id) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        LOGGER.info("Executing query: " + statement.toString());
        resultSet = statement.executeQuery();
        return resultSet;
    }

    public void executeDelete(String query, long id) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        LOGGER.info("Executing query:" + statement.toString());
        statement.executeQuery();
    }

    public void executeUpdate(String query,  long id, String column, String value) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setString(1, column);
        statement.setString(2, value);
        statement.setLong(3, id);
        LOGGER.info("Executing query:" + statement.toString());
        statement.executeUpdate();
    }

    @Override
    public void close() {
        if (Objects.nonNull(statement)) {
            try {
                statement.close();
                ConnectionPool.getInstance().releaseConnection(connection);
            } catch (SQLException | InterruptedException e) {
               LOGGER.error(e.getMessage());
            }
        }
    }
}
