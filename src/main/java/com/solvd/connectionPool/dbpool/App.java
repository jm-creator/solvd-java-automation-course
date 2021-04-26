package com.solvd.connectionPool.dbpool;

import com.solvd.connectionPool.dao.mysqlimpl.CustomerDao;
import com.solvd.connectionPool.models.BaseModel;
import com.solvd.connectionPool.models.Customer;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App implements Runnable{

    private static final Logger LOGGER = Logger.getLogger(App.class);
    private static List<String> queries = new ArrayList<>();

    @Override
    public void run() {
        Customer customer = new CustomerDao().getById(1);
        LOGGER.info(customer.toString());
        List<Customer> customers = new CustomerDao().getAll();
        customers.forEach(LOGGER::info);
    }
}
