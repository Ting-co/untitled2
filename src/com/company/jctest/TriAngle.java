package com.company.jctest;

public class TriAngle extends Person{
    private double base;
    private double height;

    public TriAngle(double b,double h){
        base=b;
        height=h;
    }

    public void study(){
        System.out.println("子类重写的方法");

    }

    public void setBase(double b){
        base=b;
    }

    public double getBase() {
        return base;
    }

    public void setHeight(double h){
        height=h;
    }

    public double getHeight(){
        return height;
    }
}
