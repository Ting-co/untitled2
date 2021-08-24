package mian.java.redoxiancheng;

public class RedoRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + Thread.currentThread().getName());

        }
    }
}

class runnableMain {
    public static void main(String[] args) {
        RedoRunnable redoRunnable = new RedoRunnable();
        Thread thread = new Thread(redoRunnable);
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(i + Thread.currentThread().getName());
            if (i == 20) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}