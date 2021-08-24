package mian.java.redofanxin;

import org.junit.Test;

import java.util.*;

public class redoFanxin {

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//        list.add("Tom");

        for(Object score : list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);

        }

    }

    @Test
    public void test2(){
        ArrayList<Integer> list =  new ArrayList<Integer>();

        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");

        //方式一：
//        for(Integer score : list){
//            //避免了强转操作
//            int stuScore = score;
//
//            System.out.println(stuScore);
//
//        }
        //方式二：
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }

    }

    @Test
    public void test3(){
//        Map<String,Integer> map = new HashMap<String,Integer>();
        //jdk7新特性：类型推断
        Map<String,Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

//        map.put(123,"ABC");
        //泛型的嵌套,值的是set带指定了map.Entry的类型，而这个类型也是泛型，也指定了String,Integer类型
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "----" + value);
        }

    }


    @Test
    public void test4(){
        //如果定义了泛型类，实例化没指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Older order = new Older();
        order.setOlder(123);
        order.setOlder("ABC");

        //建议：实例化时指明类的泛型
        Older<String> order1 = new Older<String>("orderAA",1001,"order:AA");
        // order1.setOlder(456);
        order1.setOlder("AA:hello");

    }

    @Test
    public void test5(){
        ex sub1 = new ex();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        sub1.setOlder(1122);
//        sub1.setOlder("faaf");

        //再次指明类型是错误的
       /* ex<String> sub2 = new ex<>();
        sub2.setOlder("order2...");*/
    }

    @Test
    public void test6(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //泛型不同的引用不能相互赋值。
//        list1 = list2;


    }

    //测试泛型方法
    @Test
    public void test7(){
        Older<String> order = new Older<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = order.g(arr);

        System.out.println(list);
    }

}
