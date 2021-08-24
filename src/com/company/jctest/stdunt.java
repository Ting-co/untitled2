package com.company.jctest;

public class stdunt extends Person{
    int age;
    String name;


    public stdunt(){


    }

    public stdunt(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public stdunt(int age, String name, int sex){
     this(age, name);
     this.sex=sex;

    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say1(){
        System.out.println("学生名字"+name+"age"+age);
    }

    public void study(Person person){
        stdunt s=(stdunt) person;
        s.say1();
        System.out.println("stdunt");

    }
    public void study(){

        this.say1();
        System.out.println("这里调用了子类重写的方法");

    }

    @Override
    public String toString() {
        return "stdunt{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
