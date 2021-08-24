package com.company.jctest;

import java.util.Objects;

public class Person {
    String name;
    int age;
    int sex;


    public void study(){
        System.out.println("stu");
    }
    public void showAge(){
    System.out.println(age);
    }
    public int addAge(int i){
        age =age+2;
        return age;
    }
    public void say(){
        System.out.println("学生名字"+name+"age"+age+"sex"+sex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                sex == person.sex &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

}
