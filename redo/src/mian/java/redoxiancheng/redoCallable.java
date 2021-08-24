package mian.java.redoxiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class redoCallable implements Callable {



    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i < 100; i++) {
            System.out.println(i + Thread.currentThread().getName());
            sum+=i;
        }
        return sum;
    }
}

class callableMain {
    public static void main(String[] args) {
        redoCallable redoCallable = new redoCallable();
        FutureTask objectFutureTask = new FutureTask(redoCallable);
        new Thread(objectFutureTask).start();

        try {
            Object sum =  objectFutureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}