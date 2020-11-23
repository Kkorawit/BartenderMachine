package com.company;

public class Ingredient {
    private String name; //ชื่อวัตถุดิบ
    private int price; //ราคาวัตถุดิบ

    /**
     * Constructor for Ingredient
     * @param name Name of ingredient
     * @param price Price of Ingredient
     */
    public Ingredient(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * @return name of the ingredient
     */
    public String getName() {return name;}

    /**
     * @return price of ingredient
     */
    public int getPrice() {return price;}
}
