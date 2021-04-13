package com.solvd.connectionPool;

import org.apache.log4j.Logger;
import com.solvd.connectionPool.Connection;

import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final ConnectionPool CONNECTION_POOL = new ConnectionPool();
    private static final int POOL_SIZE = 10;
    private static AtomicInteger activeConnections = new AtomicInteger(1);
    private LinkedBlockingQueue<Connection> connectionPool;
    private static ReentrantLock lock = new ReentrantLock(true);

    private ConnectionPool() {
        connectionPool = new LinkedBlockingQueue<>(POOL_SIZE);
    }

    public static ConnectionPool getInstance() {return CONNECTION_POOL;}

    public void releaseConnection(Connection connection) throws InterruptedException {
        connectionPool.put(connection);
    }

    public Connection getConnection() {
        lock.lock();
        try{
        if (activeConnections.get() <= POOL_SIZE) {
            connectionPool.put(new Connection(activeConnections.get()));
            activeConnections.incrementAndGet();
        }
        return connectionPool.take();
    } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        } finally {
            lock.unlock();
        }
        return null;
    }

    public void closeAllConnections() {
        connectionPool.forEach(connection -> {
            try {
                connection.closeConnection();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
            connectionPool = new LinkedBlockingQueue<Connection>(POOL_SIZE);
            activeConnections.getAndSet(1);
        });
    }


    public static int getPoolSize() {
        return POOL_SIZE;
    }

    public static void setActiveConnections(AtomicInteger activeConnections) {
        ConnectionPool.activeConnections = activeConnections;
    }
}
