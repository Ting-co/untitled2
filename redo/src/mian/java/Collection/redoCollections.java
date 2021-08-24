package mian.java.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class redoCollections {

    @Test
    public void test1(){
//        Collection set=new HashSet<String>();
        ArrayList arrayList = new ArrayList();
        arrayList.add(24);
        arrayList.add(341);
        arrayList.add(643);
        arrayList.add(643);

        System.out.println(arrayList);

        /*  reverse(List)：反转 List 中元素的顺序
            shuffle(List)：对 List 集合元素进行随机排序
            sort(List)：根据元素的自然顺序对指定 List 集合元素升序排序
            sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
            swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        */
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        Collections.swap(arrayList,1,2);
        System.out.println(arrayList);


        /*  Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
            Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
            Object min(Collection)
            Object min(Collection，Comparator)
            int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
            void copy(List dest,List src)：将src中的内容复制到dest中
            boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所旧值
        */
        System.out.println("**************");
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(45);
        arrayList1.add(45);


        System.out.println(Collections.max(arrayList));
        System.out.println(Collections.min(arrayList));
        System.out.println(Collections.frequency(arrayList,643));

        System.out.println(arrayList);
        Collections.replaceAll(arrayList,24,45);
        System.out.println("**************");
        System.out.println(arrayList);
        Collections.copy(arrayList,arrayList1);
        System.out.println(arrayList);

        System.out.println("**************");

          Collection collection =  Collections.synchronizedList(arrayList);
        System.out.println(collection);

    }
}
