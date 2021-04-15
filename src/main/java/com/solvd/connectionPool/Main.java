package com.solvd.connectionPool;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int AMOUNT_OF_THREADS = 15;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        App app = new App();
        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            threads.add(new Thread(app));
        }
        threads.forEach(Thread::start);
    }

}
