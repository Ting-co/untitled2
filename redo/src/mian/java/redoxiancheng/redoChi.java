package mian.java.redoxiancheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class redoChi {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executorService1 = (ThreadPoolExecutor) executorService;

        executorService1.execute(new chi1());

        executorService1.execute(new chi2());

        executorService1.shutdown();

    }
}


class chi1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + Thread.currentThread().getName());
        }
    }
}

class chi2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + Thread.currentThread().getName());
        }
    }
}