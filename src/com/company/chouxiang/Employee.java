package com.company.chouxiang;

public abstract class Employee {
   private String name;
   private int id;
   private String salary;

   public Employee(){}

    public Employee(String name, int id, String salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public abstract void  work(int id);


}
