package com.company.daili;

public class daiLies {
    public static void main(String[] args) {
       nikeFactory n= new nikeFactory();

        ProcFactory p=  new ProcFactory(n);

        p.produceCloth();
    }

}

/*代理模式*/

//要做的事情
interface Factory{
    void   produceCloth();
}

//代理类
class ProcFactory implements Factory{

    private Factory factory;

    public ProcFactory(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续的收尾工作");
    }
}


//被代理类
class nikeFactory implements Factory{

    @Override
    public void produceCloth() {
        System.out.println("nike在工作");
    }
}