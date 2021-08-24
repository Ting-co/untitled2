package com.company.project3.liJava.test;

import com.company.project3.liJava.domain.Employee;
import com.company.project3.liJava.service.NameListService;
import com.company.project3.liJava.service.TeamException;
import org.junit.Test;

public class test {
    @Test
    public  void  testget(){
        NameListService service =new NameListService();
        Employee[] employees =service.getAllEmployees();
        for (int i =0 ;i<employees.length;i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testgetemployee(){
        NameListService service =new NameListService();

        int id =102222;
        try {
            Employee employee =service.getEmployee(id);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
    }
}
