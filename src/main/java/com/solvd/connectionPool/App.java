package com.solvd.connectionPool;

import org.apache.log4j.Logger;

import static com.solvd.connectionPool.ConnectionPool.*;

public class App implements Runnable{

    private static final Logger LOGGER = Logger.getLogger(App.class);

    @Override
    public void run() {
    Connection connection = getInstance().getConnection();
     LOGGER.info("starting");

        try {
            // simulate working thread
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
        }
        try {
            getInstance().releaseConnection(connection);
            LOGGER.info("finishing");
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
