package com.company;

public class Menu {
    private String name;
    private int price;
    private int shakeTime;


    /**
     * Constructure of Menu
     * @param name Name of menu
     * @param price Price of menu
     * @param shakeTime Length of shking time of menu
     */
    public Menu(String name, int price, int shakeTime) {
        this.name = name;
        this.price = price;
        this.shakeTime = shakeTime;
    }

    /**
     * @return name of Menu
     */
    public String getName() {return name;}

    /**
     * @return Price of menu
     */
    public int getPrice() {return price;}

    /**
     * @return length of shaking time of menu
     */
    public int getShakeTime() {return shakeTime;}
}
