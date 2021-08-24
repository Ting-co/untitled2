package com.company.compare;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        compare[] compare=new compare[10];
        compare[0]=new compare("00",13);
        compare[1]=new compare("11",91);
        compare[2]=new compare("f22",36);
        compare[3]=new compare("n33",47);
        compare[4]=new compare("n44",7);


        Arrays.sort(compare);
        System.out.println(Arrays.toString(compare));

    }



}
