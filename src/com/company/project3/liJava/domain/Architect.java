package com.company.project3.liJava.domain;

public class Architect extends Designer{
    private int stock;//公司奖励的股票数量

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails()+"\t架构师\t" +getStatus()+"\t"+getBonus() +"\t"+stock+"\t"+getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getMemberId() +"/"+getId()+"\t"+getName() +"\t" +getAge()+"\t"+getSalary()+ "\t架构员" +getBonus()+"\t"+getStock();
    }
}
