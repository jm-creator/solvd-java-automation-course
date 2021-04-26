package com.solvd.connectionPool.dao;
import com.solvd.connectionPool.dbpool.ConnectionPool;


public class AbstractDao {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public AbstractDao() {connectionPool =ConnectionPool.getInstance();}

    public ConnectionPool getConnectionPool() {return connectionPool;}
}
