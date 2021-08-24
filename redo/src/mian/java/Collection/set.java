package mian.java.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class set {
    @Test
    public void test1(){
//        Collection set=new HashSet<String>();
        ArrayList arrayList = new ArrayList();
        arrayList.add("jjsj");
        arrayList.add(341);
        arrayList.add(new String("ssss"));

        HashSet set=new HashSet<Integer>(arrayList);

        set.add("sss");
        set.add(511);
        set.add(new String("sdd"));

        for (Object s : set){
            System.out.println(s);
        }

    }
}
