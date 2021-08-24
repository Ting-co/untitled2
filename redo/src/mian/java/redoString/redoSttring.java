package mian.java.redoString;


import org.junit.Test;

import java.util.Arrays;

public class redoSttring {
    public static void main(String[] args) {
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
        s1 = "hello";
        String s3 = "  HELLO  ";
        String s4 = "HELLO";

        System.out.println(s1 == s2);//比较s1和s2的地址值

        System.out.println(s1);//hello
        System.out.println(s2);//abc
        System.out.println("***************.");

        System.out.println(s1.length());
        System.out.println(s1.charAt(4));
        System.out.println(s1.isEmpty());

        System.out.println(s3.toLowerCase());
        System.out.println(s1.toUpperCase());

        System.out.println(s3.trim());
        System.out.println(s1.equals(s4));
        System.out.println(s1.equalsIgnoreCase(s4));

        System.out.println(s1.concat(s2));
        System.out.println(s1 + s2);

        System.out.println(s1.compareTo(s2));

        System.out.println(s4.substring(2));
        System.out.println(s4.substring(2, 4));

        /*subSequence和subString的区别，=无意中发现了subSequence，同样能和subString一样截取
            两者返回类型不一样。
            subString返回的是String，subSequence返回的是实现了CharSequence接口的类，也就是说使用subSequence得到的结果，
            只能使用CharSequence接口中的方法。不过在String类中已经重写了subSequence，调用subSequence方法，可以直接下转为String对象。
        * */
        System.out.println(s4.subSequence(2, 3));

        System.out.println(s1.endsWith("o"));
        System.out.println(s1.endsWith("f"));
        System.out.println(s1.startsWith("f"));
        System.out.println(s1.startsWith("h"));
        System.out.println(s1.startsWith("h", 2));
        System.out.println(s1.startsWith("h", 0));

        System.out.println(s1.contains("llo"));


        //indexOf和lastIndexOf方法如果未找到都是返回-1

        System.out.println(s1.indexOf("l"));
        System.out.println(s1.indexOf("l", 1));
        System.out.println(s1.indexOf("lo", 1));
        System.out.println(s1.lastIndexOf("l"));
        System.out.println(s1.lastIndexOf("l", 1));
        System.out.println(s1.lastIndexOf("lo", 1));

        System.out.println("**********************");

        System.out.println(s1.replace("1", "o"));
        System.out.println(s1.replace("l", "i"));
        //regex,表示正则表达式
        s1.replaceAll("h*", "l");
        /*String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所匹配给定的正则表达式的子字符串。
            String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
           匹配:
            boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
            切片：
            String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
            String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，
            剩下的全部都放到最后一个元素中。
            */
        System.out.println(s1);

/*
        String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
        基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)*/

        String str1 = "123";
        String str5 = "akf";
//        int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);
        int num2 = 123;


        String str2 = String.valueOf(num);//"123"
        String str0 = String.valueOf(num2);
        String str3 = num + "";
        String str9 = str0 + "";

        System.out.println(str1 == str3);
        System.out.println(str1 == str2);
        System.out.println(str1 == str0);
        System.out.println(str1 == str9);
        System.out.println(str1);
        System.out.println(str3);
        System.out.println(str2);
        System.out.println(str9);
        System.out.println(num);

        System.out.println("**************");


        String st1 = "abc123";  //题目： a21cb3

        char[] charArray = st1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String st2 = new String(arr);
        System.out.println(st2);

        System.out.println("**************");
        String s11 = "abc123中国";
        byte[] bytes = s11.getBytes();//使用默认的字符集，进行编码。
        System.out.println(Arrays.toString(bytes));

        String s22 = new String(bytes);//使用默认的字符集，进行解码。
        System.out.println(s22);



    }

    @Test
    public void kk(){

    }
}
