package com.company.chouxiang;

public class Manager extends Employee implements Fll{
   private int bonus;


    public Manager(int bonus) {
        this.bonus = bonus;
    }

    public  void  work(int id){
        super.setId(id);

        System.out.println("我是员工"+getId());
        Fll.super.k();
    };


    public void k() {
        System.out.println("F12");
    }
}
