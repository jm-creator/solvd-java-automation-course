package com.solvd.connectionPool;

import com.solvd.connectionPool.dbpool.App;
import com.solvd.connectionPool.utils.StAXParser;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int AMOUNT_OF_THREADS = 1;
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        App app = new App();
        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            threads.add(new Thread(app));
        }
        threads.forEach(Thread::start);


        StAXParser stAXParser = new StAXParser();
        stAXParser.parser();
    }
}
