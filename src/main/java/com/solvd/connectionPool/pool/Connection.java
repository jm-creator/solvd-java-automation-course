package com.solvd.connectionPool.pool;

import org.apache.log4j.Logger;

public class Connection implements AutoCloseable{
    //////first pool implementation ///////
    private int idConnection;
    private static final Logger LOGGER = Logger.getLogger(Connection.class);

    public Connection(int id) {
        this.idConnection = id;
    }

    public int getIdConnection() {
        return idConnection;
    }

    public void setIdConnection(int idConnection) {
        this.idConnection = idConnection;
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("releasing connection");
       ConnectionPool.getInstance().releaseConnection(this);
    }
}
