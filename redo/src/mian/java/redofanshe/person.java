package mian.java.redofanshe;

public class person {


        private String model;//机器型号
        private String display;//显示器名称

        public person() {
        }

        public person(String model, String display) {
            this.model = model;
            this.display = display;
        }

    @Override
    public String toString() {
        return "person{" +
                "model='" + model + '\'' +
                ", display='" + display + '\'' +
                '}';
    }

    public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getDisplay() {
            return display;
        }

        public void setDisplay(String display) {
            this.display = display;
        }


    public  void  print(){
        System.out.println("真的调用了这类");
    }

    public  String  p(String s){
        System.out.println("真的调用了这类"+s);
        return s;
    }

    public  Integer  i (Integer i){
        System.out.println("真的调用了这类"+i);
        return i;
    }

    public static void  dostatic(){
        System.out.println("真的调用了静态");
    }



    public static String  dostatic2(String s){
        System.out.println("真的调用了静态"+s);
        return s;
    }

    public static void  dostatic3(String s){
        System.out.println("真的调用了静态"+s);

    }

    public static String  dostatic4(String s ,Integer i){
        System.out.println("真的调用了静态"+s+i);
        return s+i;
    }
    public static void  dostatic5(int s){
        System.out.println("真的调用了静态"+s);

    }

    public static int[]  dostatic6(int ... arr){

        for(int i:arr){
            System.out.println("真的调用了静态"+i);
        }
        return arr;
    }

    public static String[]  dostatic6(String ... arr){

        for(String i:arr){
            System.out.println("真的调用了静态"+i);
        }
        return arr;
    }
}
