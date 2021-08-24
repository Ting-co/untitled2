package mian.java.redofanxin;

import java.util.ArrayList;
import java.util.List;

public class Older<T> {
    private String name;
    private int id;
    T older;

    public Older() {
        //编译不通过
        // T[] arr =new T[10];
        //编译通过
        T[] arr = (T[]) new Object[10];

    }

    public Older(String name, int id, T older) {
        this.name = name;
        this.id = id;
        this.older = older;
    }

    public void setOlder(T older) {
        this.older = older;
    }

    public T getOlder() {
        return older;
    }

    @Override
    public String toString() {
        return "Older{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", older=" + older +
                '}';
    }

    //静态方法中不能使用类的泛型。
    /*public static void sOlder(T older) {
        System.out.println("JJ");
    }*/

    public static <E> List<E> g(E[] aar) {
        ArrayList<E> list = new ArrayList<>();

        for (E e : aar) {
            list.add(e);
        }
        return list;
    }
}
