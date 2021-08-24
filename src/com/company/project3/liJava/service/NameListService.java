package com.company.project3.liJava.service;

import com.company.project3.liJava.domain.*;
import com.sun.jmx.snmp.SnmpNull;
import static com.company.project3.liJava.service.Data.*;

public class NameListService {
    private Employee[] employees;

    public NameListService() {

        employees = new  Employee[Data.EMPLOYEES.length];

        for (int i=0;i<employees.length;i++){
            //获取员工类型
            int type= Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee的4个基本信息
            int id= Integer.parseInt(EMPLOYEES[i][1]);
            String name= EMPLOYEES[i][2];
            int age= Integer.parseInt(EMPLOYEES[i][3]);
            double salary= Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;

            switch (type){
                case EMPLOYEE:
                    employees[i] =new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment=createEquipment(i);
                    employees[i] =new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment=createEquipment(i);
                    bonus=Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] =new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment=createEquipment(i);
                    bonus=Double.parseDouble(EMPLOYEES[i][5]);
                    stock=Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i]=new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }

    private Equipment createEquipment(int index){
        int key =Integer.parseInt(EQUIPMENTS[index][0]);

        String modelOrName =EQUIPMENTS[index][1];
        switch (key){
            case PC:
                String display= EQUIPMENTS[index][2];
                return new PC(modelOrName,display);
            case NOTEBOOK:
                double price =Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(modelOrName,price);
            case PRINTER:
                String type =EQUIPMENTS[index][2];
                return new Printer(modelOrName,type);
        }
        return null;
    }

    public Employee[] getAllEmployees(){
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i=0;i<employees.length;i++){
            if(employees[i].getId() ==id){
                return employees[i];

            }
        }
        throw new TeamException("找不到指定员工");

    }
}
