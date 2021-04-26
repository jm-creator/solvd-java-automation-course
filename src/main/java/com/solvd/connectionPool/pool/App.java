package com.solvd.connectionPool.pool;

import org.apache.log4j.Logger;



public class App implements Runnable{

    private static final Logger LOGGER = Logger.getLogger(App.class);

    @Override
    public void run() {

        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            // simulate working thread
            LOGGER.info("connection obtained");
            Thread.sleep(2000);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}
