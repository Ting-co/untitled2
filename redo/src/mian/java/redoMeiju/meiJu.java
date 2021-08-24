package mian.java.redoMeiju;

public class meiJu {
    //1.
    private  final String seasoname ;
    private  final String seasoDesc ;

    public meiJu(String seasoname, String seasoDesc) {
        this.seasoname = seasoname;
        this.seasoDesc = seasoDesc;
    }

    public   static final  meiJu  SPRING=new meiJu("春天","hua");
    public  static final  meiJu  SUNMER=new meiJu("夏天","re");
    public   static final  meiJu  AUTTER=new meiJu("秋天","feng");
    public   static final  meiJu  WINTER=new meiJu("冬天","cool");

    public String getSeasoname() {
        return seasoname;
    }

    public String getSeasoDesc() {
        return seasoDesc;
    }

    @Override
    public String toString() {
        return "meiJu{" +
                "seasoname='" + seasoname + '\'' +
                ", seasoDesc='" + seasoDesc + '\'' +
                '}';
    }



}


enum meiJu1 implements mei{

    //每个去实现show，或者下面实现show
    SPRING("春天","hua"){
        @Override
        public void show() {

        }
    },
    SUNMER("夏天","re") {
        @Override
        public void show() {

        }
    },
    AUTTER("秋天","feng") {
        @Override
        public void show() {

        }
    },
    WINTER("冬天","cool") {
        @Override
        public void show() {

        }
    };

    private  final String seasoname ;
    private  final String seasoDesc ;

    meiJu1(String seasoname, String seasoDesc) {
        this.seasoname = seasoname;
        this.seasoDesc = seasoDesc;
    }

    public String getSeasoname() {
        return seasoname;
    }

    public String getSeasoDesc() {
        return seasoDesc;
    }



/*    @Override
    public String toString() {
        return "meiJu1{" +
                "seasoname='" + seasoname + '\'' +
                ", seasoDesc='" + seasoDesc + '\'' +
                '}';
    }*/
}