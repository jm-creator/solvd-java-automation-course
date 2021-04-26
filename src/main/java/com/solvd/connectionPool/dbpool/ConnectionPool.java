package com.solvd.connectionPool.dbpool;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private static final ConnectionPool CONNECTION_POOL = new ConnectionPool();
    private static final int POOL_SIZE = 10;
    private static AtomicInteger activeConnections = new AtomicInteger(1);
    private LinkedBlockingQueue<java.sql.Connection> connectionPool;
    private static ReentrantLock lock = new ReentrantLock(true);

    private ConnectionPool() {
        connectionPool = new LinkedBlockingQueue<>(POOL_SIZE);
    }

    public static ConnectionPool getInstance() {return CONNECTION_POOL;}

    public void releaseConnection( Connection connection) throws InterruptedException {
        connectionPool.put(connection);
    }

    public Connection getConnection() {
        lock.lock();
        try{
        if (activeConnections.get() <= POOL_SIZE) {
            connectionPool.put(getConnectionFromPropertyFile().orElseThrow(SQLException::new));
            activeConnections.incrementAndGet();
        }
        return connectionPool.take();
        } catch (InterruptedException | SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            lock.unlock();
        }
        return null;
    }

    private static Optional<java.sql.Connection> getConnectionFromPropertyFile() {
        try {
            Properties jdbcProperties = new Properties();
            jdbcProperties.load(new FileInputStream("src/main/resources/jdbc.properties"));
            return Optional.ofNullable(DriverManager.getConnection(jdbcProperties.getProperty("jdbc.conn.url"),
                    jdbcProperties.getProperty("jdbc.username"),
                    jdbcProperties.getProperty("jdbc.password")));
        } catch (IOException | SQLException e) {
            LOGGER.error(e);
        }
        return Optional.empty();
    }

    public void closeAllConnections() {}


    public static int getPoolSize() {
        return POOL_SIZE;
    }

    public static void setActiveConnections(AtomicInteger activeConnections) {
        ConnectionPool.activeConnections = activeConnections;
    }
}
