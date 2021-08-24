package mian.java.redoMeiju;

import org.junit.Test;

public class meijuTest {

    @Test
    public  void   meiju1Test(){
        meiJu spring = meiJu.SPRING;
        System.out.println(spring);

    }

    @Test
    public  void   meiju2Test(){
        meiJu1 spring = meiJu1.SPRING;
        System.out.println(spring.toString());

        meiJu1[] values = meiJu1.values();
        for (Object obj:values) {
            System.out.println(obj);
        }
        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        meiJu1 winter= meiJu1.valueOf("WINTER");

        System.out.println(winter);


    }
}
