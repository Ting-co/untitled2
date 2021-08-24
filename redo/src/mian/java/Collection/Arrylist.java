package mian.java.Collection;

import org.junit.Test;

import java.util.*;


public class Arrylist {
    @Test
    public  void  zhuanhuan(){

//        Arrylist arrylist = new Arrylist();
        Collection arr =new ArrayList();

        arr.add("ddj");
        arr.add("ddj");
        arr.add("ddj");
        arr.add("ddj");

        //转化成数组
        Object[] objects = arr.toArray();

        //增强for循环
        //for(数组元素的类型 局部变量 : 数组对象)
        for (Object o : objects){
            System.out.println(o);
        }

        //数组转换成集合
        List objects1 = Arrays.asList(objects);
//        List<Object> objects1 = Arrays.asList(objects);
        System.out.println(objects1);

    }

    @Test
    public  void  zhuanhuan2() {

//        Arrylist arrylist = new Arrylist();
        Collection arr = new ArrayList();

        arr.add("ddj");
        arr.add("ddj");
        arr.add("ddj");
        arr.add(new String("Tom"));
//        arr.remove("Tom");


        //Iterator对象称为迭代器(设计模式的一种)
        Iterator it1 = arr.iterator();
        while (it1.hasNext()){

            System.out.println(it1.next());

        }

    }


    @Test
    public  void  zhuanhuan3() {

//        Arrylist arrylist = new Arrylist();
        ArrayList arr = new ArrayList(5);

        arr.add("ddj");
        arr.add("ddj");
        arr.add("ddj");
        arr.add(new String("Tom"));
//        arr.remove("Tom");
        //arr.remove(3);
        arr.set(0,"0");
        System.out.println(arr.get(0));
        arr.add(3,"ll");



        System.out.println("**"+arr.size()+"**");
        //Iterator对象称为迭代器(设计模式的一种)
        Iterator it1 = arr.iterator();
        while (it1.hasNext()){

            System.out.println(it1.next());

        }

    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中"Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
          // iterator.remove();
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
                //iterator.remove();
            }

        }
        //遍历集合,这里需要重新再调一次iterator()。
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public  void  zhua() {

//        Arrylist arrylist = new Arrylist();
        ArrayList arr = new ArrayList();

        arr.add(1);
        arr.add("ddj");
        arr.add("ddj");
        arr.add(new String("Tom"));
       arr.remove(1);
       arr.remove("1");
       //想要删除1，这样操作
        arr.remove(new Integer(1));

        //Iterator对象称为迭代器(设计模式的一种)
        Iterator it1 = arr.iterator();
        while (it1.hasNext()){

            System.out.println(it1.next());

        }

    }
}
