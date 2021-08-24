package com.company.thred;

public class run {

    public static void main(String[] args) {

        testd r=new testd();
        Thread t1=new  Thread(r);
        Thread t2=new  Thread(r);
        Thread t3=new  Thread(r);
        t1.setName("一");
        t2.setName("二");
        t3.setName("三");
        t1.start();
        t2.start();
        t3.start();
    }

}

class testd implements Runnable{
    private int tip=100;
    dog d= new dog();
    public  void run() {

            while (true) {

                synchronized (testd.class) {
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

class  dog {
    int i ;
    public int dog(int i){
        return ++i;
    }
}