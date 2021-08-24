package mian.java.redoxiancheng;

import java.util.concurrent.locks.ReentrantLock;

public class redoMaip implements Runnable {
    private int piao = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        /*
        * synchronized 同步代码块
        * */
       /* while (true) {
            synchronized (this) {
                if (piao > 0) {
                    System.out.println(piao + Thread.currentThread().getName());
                    piao--;
                } else {
                    break;
                }
            }
        }*/

       /*
       * lock锁解决线程安全问题
       * lock要3步：1实例化ReentrantLock() 2调用lock.lock 3关闭锁 lock.unlock():
       * */

        while (true) {
            try {
                lock.lock();
                if (piao > 0) {
                    System.out.println(piao + Thread.currentThread().getName());
                    piao--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

class rmain {
    public static void main(String[] args) {
        redoMaip redoMaip = new redoMaip();
        Thread thread1 = new Thread(redoMaip);
        Thread thread2 = new Thread(redoMaip);
        thread1.setName("paio1");
        thread2.setName("paio2");
        thread1.start();
        thread2.start();

    }
}