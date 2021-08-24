package com.company.chouxiang;

public class test {
    public static void main(String[] args) {
        Manager m =new Manager(2);
        m.work(1);

        Employee[] e= new Employee[3];
        e[0]=new Manager(3);
        System.out.println(e[0]);

        }
    }

