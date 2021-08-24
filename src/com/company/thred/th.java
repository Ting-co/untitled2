package com.company.thred;

public class th extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        th th = new th();
        th.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i+"***main**");
        }

    }
}


