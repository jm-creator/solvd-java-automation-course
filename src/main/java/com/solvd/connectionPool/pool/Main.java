package com.solvd.connectionPool.pool;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // //////first pool implementation ///////
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
