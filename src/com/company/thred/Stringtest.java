package com.company.thred;

public class Stringtest {
    public static void main(String[] args) {
        String str1= "  li d";
        char[] cha=str1.toCharArray();

        for( int i = 0;i<cha.length-1;i++)
        {
            if (cha[i]==' ') {
                for (int j = i; j < cha.length-i-1;j++ ) {
                    cha[j] = cha[j + 1];
                }
            }
        }

        System.out.println(cha[0]);
        System.out.println(cha);
    }
}
