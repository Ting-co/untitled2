package mian.java.redoString;


public class sssString {

    public static void main(String[] args) {
        String string = new String("jjj");

        StringBuffer stringBuffer = new StringBuffer(string);

        String s = new String(stringBuffer);
        System.out.println(stringBuffer);
        System.out.println(s);
        stringBuffer.append("ss");
        System.out.println(stringBuffer);
        stringBuffer.delete(3,4);
        System.out.println(stringBuffer);
        stringBuffer.setCharAt(3,'k');
        System.out.println(stringBuffer);
        stringBuffer.replace(2,4,"lj");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.charAt(3));
        //表示在第几前面插入
        System.out.println(stringBuffer.insert(3,4));
        System.out.println(stringBuffer.insert(0,2));
        System.out.println(stringBuffer.length());

        for (int i = 0; i < stringBuffer.length(); i++) {
            System.out.println(stringBuffer.charAt(i));
        }
        System.out.println(stringBuffer.toString());


    }

}
