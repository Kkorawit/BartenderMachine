package com.company;

public class Menu {
    private String name;
    private int price;
    private int shakeTime;
//
//    public Menu(String name,int price){
//        this.name = name;
//        this.price = price;
//    }
    public Menu(String name, int price, int shakeTime) {
        this.name = name;
        this.price = price;
        this.shakeTime = shakeTime;
    }
    public String getName() {return name;}
    public int getPrice() {return price;}
    public int getShakeTime() {return shakeTime;}
}
