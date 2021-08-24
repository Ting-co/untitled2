package com.company.jctest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    	stdunt p =new stdunt(11,"ll");
    	p.study();
    	Person t=p;
    	t.study();
    	/*
    	    Person p1=new stdunt();
    	    上面的过程即下面的，即类的提升将低的升为父类的
    	    stdunt p =new stdunt();
    	    Person t=p;

    	 */
    	System.out.println("************");
    	//因为新new了个空间，所以里面没有age,name，没有值，上面是进行了转化，所以有值
    	Person p1=new stdunt();
        p1.study();
        Integer i1=new Integer(1);
        int i=i1.intValue();
        System.out.println(i);
        Person p3=new Person();
        System.out.println(p3 instanceof stdunt);

        System.out.println("**********************************");
         int q=2;
         Integer q1=i;
        System.out.println(p);
        System.out.println(p.toString());


    }

    @Test
    public void tesst(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<stdunt> list3 = new ArrayList<stdunt>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;编译不通过

//        list2 = list3; 编译不通过
        list2 = list4;
        list2 = list5;

        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
       // stdunt s = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);
   //     编译不通过
//        Person obj = list2.get(0);

        //写入数据：
        //编译不通过
//        list1.add(new Student());
       // list1.add(new Person());

        //编译通过
        list2.add(new Person());
        list2.add(new stdunt());
    }

}


