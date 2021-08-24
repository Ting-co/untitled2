package com.company.test;

import org.junit.Test;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        tel t1=tel.k();
        tel t2=tel.k();
        System.out.println(t1);
        System.out.println(t1==t2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("ss");
        String s = scanner.next();
        System.out.println(s);
    }

    @Test
    public void teachar5()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ss:");
        String s = scanner.next();
        System.out.println(s);
    }

}
class tel{

    //单例模式有两种模式：饿汉模式，懒汉模式
    //饿汉模式
    //1，先创建一个空的构架器
    private   tel(){

    }
    //2,内部创建一个类的对象
    //4,因为方法是静态的，所以要求返回的类的对象也是静态的，要求类的对象也是静态的声明
    private static tel t=new tel();

    //3，建立一个公共的静态方法，返回类的对象
    public static tel k(){
        return t;
    }
    /*懒汉模式的234步骤
    //2,内部创建一个类的对象
    //4,因为方法是静态的，所以要求返回的类的对象也是静态的，要求类的对象也是静态的声明
    private static tel t=null;

    //3，建立一个公共的静态方法，返回类的对象
    public static tel k(){
        if (t==null)
        {
            t=new tel();
        }
        return t ;
    }*/
}