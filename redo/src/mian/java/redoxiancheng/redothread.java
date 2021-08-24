package mian.java.redoxiancheng;

public class redothread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            System.out.println( i+Thread.currentThread().getName() );
        }
    }
}

class thmain {
    public static void main(String[] args) {

        redothread redothread = new redothread() ;
//        redothread redothread1 = new redothread();
//        redothread redothread2 = new redothread();
        redothread.setName("nue1");
//        redothread1.setName("nue2");
        redothread.start();
//        redothread1.start();
        /*
        * join方法在继承的Thread中使用，在runnable中要调用调用实现类的对象的名字才能使用
        * */
        for (int i = 0; i <100; i++) {
            System.out.println(i + Thread.currentThread().getName());

            if (i==20){
                try {
                    redothread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}