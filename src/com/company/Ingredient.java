package com.company;

public class Ingredient {
    private String name; //ชื่อวัตถุดิบ
    private int price; //ราคาวัตถุดิบ

    public Ingredient(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {return name;}
    public int getPrice() {return price;}
}
