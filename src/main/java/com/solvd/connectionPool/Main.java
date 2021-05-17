package com.solvd.connectionPool;

import com.solvd.connectionPool.dao.CustomerMapper;
import com.solvd.connectionPool.dao.mysqlimpl.CustomerDao;
import com.solvd.connectionPool.dbpool.App;
import com.solvd.connectionPool.models.BaseModel;
import com.solvd.connectionPool.models.Customer;
import com.solvd.connectionPool.utils.*;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private static final int AMOUNT_OF_THREADS = 1;
    public static void main(String[] args) {
//        List<Thread> threads = new ArrayList<>();
//        App app = new App();
//        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
//            threads.add(new Thread(app));
//        }
//        threads.forEach(Thread::start);


        StAXParser stAXParser = new StAXParser();
        stAXParser.parser();


        Customers customers = (Customers) JaxBParser.deSerialize(Customers.class);
        LOGGER.info(customers.toString());



    }
}
