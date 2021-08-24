package com.company.jctest;

public class TriAngleTest {
    public static void main(String[] args) {

        TriAngle t=new TriAngle(10,10);
        System.out.println(t.getBase());
       System.out.println((t.getBase()*t.getHeight())/2);

    }
}
