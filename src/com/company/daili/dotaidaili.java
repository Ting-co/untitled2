package com.company.daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class dotaidaili {
    public static void main(String[] args) {
        SuperMan superMan =new SuperMan();

        /*
        *human 返回一代理类和被代理类的一个共同的接口
        * */
        Human proxyInstance  = (Human) ProxyFactory.getProxyInstance(superMan);
       String belief= proxyInstance.getBelibf();
        System.out.println(belief);
        proxyInstance.eat("四传");



        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        nikeFactory nikeFactory=new nikeFactory();
      Factory jj=  (Factory) ProxyFactory.getProxyInstance(nikeFactory);
      jj.produceCloth();
    }
}

interface Human{
    String getBelibf();
    void eat(String food);


}


class SuperMan implements Human{

    @Override
    public String getBelibf() {
        return "my name shi i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}

/*
要实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
问题二：当通过代理的对象调用方法时，如何动态的去调用被代理类中的同名方法
*/

class ProxyFactory{
    //调用该方法返回一个代理类的对象
    //这里的形参obj是被代理类的对象
    public static Object getProxyInstance(Object obj){

       MyInvocationHandler handler= new MyInvocationHandler();

       handler.bind(obj);
        /*
        * Proxy.newProxyInstance这个是调用现成的代理方法，利用反射下的一个方法：创建一个代理类对象
        * 第一个返回值是返回需要被代理的类加载器。被代理对象是那个类加载的，代理类就跟他一样
        * 第二个是返回一个被代理类的要实现的接口，代理类实现和被代理类一样的接口。这里实现代理类实习和被代理类的一样接口
        *    前面两个负责创建代理类工厂，后面这个实现相应的方法.
        * 第三个是返回下面那个实现被代理类方法调用的类
        * */
      return   Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj;

    public void bind(Object obj){
        this.obj=obj;
    }


    /*
    * 当我们通过上面代理类的对象，调用方法a时，就会自动调用以下的方法：invoke
    * 将被代理类要执行的方法a的功能就声明在invoke（）中
    * 第一个形参是，被代理类的对象，第二个是被代理类的对象要执行的方法，第三个是被代理类要返回的值：如这题的proxyInstance.eat("四传");四传
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object returValue = method.invoke(obj,args);
        return returValue;
    }
}