package mian.java.redofanshe;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class classTest {
    @Test
    public void test1() throws Exception {
        Class p1 = person.class;
        System.out.println(p1);

        person person = new person();
        Class p2 = person.getClass();
        System.out.println(p2);

        Class p3 = Class.forName("mian.java.redofanshe.person");
        System.out.println(p3);


    }

    @Test
    public void test2() throws Exception {
        Class<person> p1 = person.class;
        System.out.println(p1);

        person person = new person();
        Class p2 = person.getClass();
        System.out.println(p2);

        Class<person> p3 = (Class<mian.java.redofanshe.person>) Class.forName("mian.java.redofanshe.person");
        System.out.println(p3);

        person o = p3.newInstance();
        o.print();

        person o1 = p1.newInstance();
        o1.print();
    }

    @Test
    public void test3() throws Exception {
        Class classs = person.class;
        System.out.println(classs);

        //属性的调用
        Object p = classs.newInstance();
        Field na = classs.getDeclaredField("model");

        na.setAccessible(true);
        na.set(p, "出来啦");
        System.out.println(na.get(p));

    }

    @Test
    public void test4() throws Exception {
        Class classs = person.class;
        System.out.println(classs);

        //无参方法的调用
        Object p = classs.newInstance();
        Method print = classs.getDeclaredMethod("print", null);

        print.setAccessible(true);

        print.invoke(p, null);
    }

    @Test
    public void test5() throws Exception {
        Class classs = person.class;
        System.out.println(classs);

        //有参方法的调用
        Object p = classs.newInstance();
        //p方法是形参是String类型的，i方法是Integer类型
        // Method print = classs.getDeclaredMethod("p", String.class);
        Method print = classs.getDeclaredMethod("i", Integer.class);

        print.setAccessible(true);

        Object aNull = print.invoke(p, 546456);

        System.out.println(aNull);


        System.out.println("*************如何调用静态方法*****************");
        /*静态方法的调用， 无参数，无返回*/

        Method dostatic = classs.getDeclaredMethod("dostatic",null);
        dostatic.setAccessible(true);

//        dostatic.invoke(person.class);

        System.out.println(dostatic.invoke(person.class));

        //没有返回值，写null
        // dostatic.invoke(null);
    }


    //静态方法的调用， 有参数，需返回
    @Test
    public void test6() throws Exception {
        Class classs = person.class;

        Object p = classs.newInstance();

        Method dostatic = classs.getDeclaredMethod("dostatic2",String.class);
        dostatic.setAccessible(true);

//        dostatic.invoke(person.class);


        /* 静态方法不属于任何对象,静态方法属于类本身.
            此时把invoke方法的第一个参数设置为null即可
        */
//        System.out.println(dostatic.invoke(p, "ssss"));
        System.out.println(dostatic.invoke(person.class, "ssss"));
//        System.out.println(dostatic.invoke(null, "ssss"));

     //   System.out.println(dostatic.invoke("ssss"));   //如果不设为null，就设置为当前类，不能不写，这样会报错



    }

    //静态方法的调用， 有参数，无返回  与上面有返回相似
    @Test
    public void test7() throws Exception {
        Class classs = person.class;

        Object p = classs.newInstance();

        Method dostatic = classs.getDeclaredMethod("dostatic3",String.class);
        dostatic.setAccessible(true);

//        dostatic.invoke(person.class);


        /* 静态方法不属于任何对象,静态方法属于类本身.
            此时把invoke方法的第一个参数设置为null即可
        */
//        System.out.println(dostatic.invoke(p, "ssss"));
        System.out.println(dostatic.invoke(person.class, "ssss"));
//        System.out.println(dostatic.invoke(null, "ssss"));

        //   System.out.println(dostatic.invoke("ssss"));   //如果不设为null，就设置为当前类，不能不写，这样会报错



    }

    //静态方法的调用， 有多参数，有返回
    @Test
    public void test8() throws Exception {
        Class classs = person.class;

        Object p = classs.newInstance();

        Method dostatic = classs.getDeclaredMethod("dostatic4",String.class,Integer.class);
        dostatic.setAccessible(true);

//        dostatic.invoke(person.class);


        /* 静态方法不属于任何对象,静态方法属于类本身.
            此时把invoke方法的第一个参数设置为null即可
        */
//        System.out.println(dostatic.invoke(p, "ssss"));
        System.out.println(dostatic.invoke(person.class, "ssss",9));
//        System.out.println(dostatic.invoke(null, "ssss"));

        //   System.out.println(dostatic.invoke("ssss"));   //如果不设为null，就设置为当前类，不能不写，这样会报错

    }

    //静态方法的调用， 有参数，无返回，参数是基本数据类型
    @Test
    public void test9() throws Exception {
        Class classs = person.class;

        Object p = classs.newInstance();

        Method dostatic = classs.getDeclaredMethod("dostatic5",int.class);
        dostatic.setAccessible(true);

//        dostatic.invoke(person.class);


        /* 静态方法不属于任何对象,静态方法属于类本身.
            此时把invoke方法的第一个参数设置为null即可
        */
//        System.out.println(dostatic.invoke(p, "ssss"));
        System.out.println(dostatic.invoke(person.class, 9));
//        System.out.println(dostatic.invoke(null, "ssss"));

        //   System.out.println(dostatic.invoke("ssss"));   //如果不设为null，就设置为当前类，不能不写，这样会报错

    }

    //静态方法的调用， 有参数，无返回，参数是可变数据形参
    @Test
    public void test10() throws Exception {
        Class classs = person.class;

        Object p = classs.newInstance();

        Method dostatic = classs.getDeclaredMethod("dostatic6",String[].class);
        dostatic.setAccessible(true);

//        dostatic.invoke(person.class);

        //如果是基本数据类型的可变数据形参
       // System.out.println(dostatic.invoke(person.class, new int[]{1,2,3,5}));
        //System.out.println(dostatic.invoke(person.class, new Object[]{new int[]{1,2,3,5}}));

        //如果是引用数据类型的可变数据形参
        //System.out.println(dostatic.invoke(person.class, new String[]{"dss","dss","dss","dss"})); //这样写法是错误的
        System.out.println(dostatic.invoke(person.class, new Object[]{new String[]{"dss","dss","dss","dss"}}));

    }

    @Test
    public void test11() throws Exception {
        Class classs = person.class;

        Object p = classs.newInstance();

        Constructor d1 = classs.getDeclaredConstructor(String.class, String.class);
       // Constructor d1 = classs.getDeclaredConstructor(String.class);

        d1.setAccessible(true);
        /*person p1 = (person) d1.newInstance("kk", "kl");
        System.out.println(p1.toString());*/
        System.out.println(d1.newInstance("kk", "kl"));

    }
}

