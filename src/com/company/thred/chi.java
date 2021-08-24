package com.company.thred;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class chi {
    public static void main(String[] args) {
        ExecutorService service=Executors.newFixedThreadPool(10);
        the t1=new the();

        Thread thread=new Thread(t1);
        Thread thread2=new Thread(t1);
        service.submit(thread);
        service.submit(thread2);


        service.shutdown();
    }
}
class the implements Runnable{
    private int tip=100;
    @Override
    public void run() {
            while (true) {
                    synchronized (this){
                    if (tip > 0) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ":" + tip);
                        tip--;
                    } else {
                        break;
                    }




        }
    }
    }
}