package com.company.compare;

public class compare implements Comparable{
    private String name;
    private  int price;

    public compare() {
    }

    public compare(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "compare{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }




   /* @Override
    public int compareTo(Object o) {
        if (o instanceof compare){
            compare com= (compare) o;

            if (this.price>com.price){
                return 1;
            }else if (this.price<com.price){
                return -1;
            }else {
                return 0;
            }

        }
            throw  new  RuntimeException("传人错误");
    }*/

    @Override
    public int compareTo(Object o) {
        if (o instanceof compare){
            compare com= (compare) o;

            if (this.name.equals(com.name)){
                return - Double.compare(this.price,com.price);
            }else {
                return this.name.compareTo(com.name);
            }

        }
        throw  new  RuntimeException("传人错误");
    }

}
