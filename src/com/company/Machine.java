package com.company;

import java.util.Scanner;
import java.lang.Thread;


public class Machine {
    private int moneyInMachine;
    Scanner scn = new Scanner(System.in);
    private int chooseIngredients;
    private int[] customerIngredients = new int[5];
    private int customerMenu;
    private Ingredient[] allIngredientAndPRice = {new Ingredient("WATER", 10), new Ingredient("LEMON", 20), new Ingredient("BROWNSUGAR", 15), new Ingredient("COLDWATER", 13), new Ingredient("ICE", 8), new Ingredient("LIMEADE", 30), new Ingredient("STRAWBERRY", 27), new Ingredient("LEMONJUICE", 29), new Ingredient("MINT", 12), new Ingredient("POMEGRANATESYRUP", 34), new Ingredient("LEMONSODA", 26), new Ingredient("CHERRYSYRUP", 42), new Ingredient("ROSEMARRYSYRUP", 24), new Ingredient("PINEAPPLEJUICE", 28)};
    private Menu[] allMenuAndPrice = {new Menu("LEMONADE", 50, 10), new Menu("GRAPE FRUIT ROSEMARRY", 60, 10), new Menu("CHIRLEY TEMPLE", 70, 70), new Menu("STRAWBERRY LEMONADE", 80, 10), new Menu("PINEAPPLE CHERRY MOCKTAIL", 10, 50)};
    private int menuPrice;
    private int totalPrice;
    private int time;
    private int shakeTime;
    private int change;
    private int customerMoney;


    //========== CHOICE 1 ==========
    public void showMenu() {
        System.out.println("========== MENU ==========");
        for (int i = 0; i < allMenuAndPrice.length; i++) {
            System.out.println( (i+1) + " " +  allMenuAndPrice[i].getName());
        }
    }

    //==========CHOICE 2==========
    public void chooseMenu() throws InterruptedException {
        showMenu();
        System.out.print("Choose Menu : ");
        customerMenu = scn.nextInt()-1;
        for (int i = 0; i < allMenuAndPrice.length; i++) {
            if (customerMenu == i) {
                menuPrice = allMenuAndPrice[i].getPrice();
                break;
            }
        }
        System.out.println("Your menu is : " + allMenuAndPrice[customerMenu].getName());
        System.out.println("Price : " + menuPrice);
        System.out.println("Shaking Time : " + allMenuAndPrice[customerMenu].getShakeTime());
        receiveMoneyFromCustomer();
        shaking(allMenuAndPrice[customerMenu].getShakeTime());
    }

    //==========CHOICE 3==========
    public void createMenu() throws InterruptedException {
        System.out.println("This is Ingredient");
        showAllIngredient();
        chooseIngredient();
        showIngredient();
        chooseShakeTime();
        receiveMoneyFromCustomer();
        addIngredient();
        shaking(shakeTime);
    }

    public void showAllIngredient() {
        for (int i = 0; i < allIngredientAndPRice.length; i++) {
            System.out.println((i + 1) + " : " + allIngredientAndPRice[i].getName() + " " + allIngredientAndPRice[i].getPrice() + " Bath.");
        }
    }

    public void chooseIngredient() {
        System.out.println("-+-+-+ Please Choose your Ingredients +-+-+-");
        resetCustomerIngerdients();
        for (int count = 0; count < customerIngredients.length; count++) {
            chooseIngredients = 0;
            System.out.print("Ingredient " + (count + 1) + " : ");
            chooseIngredients = scn.nextInt() - 1;
            for (int i = 0; i < customerIngredients.length; i++) {
                if (customerIngredients[i] == 0) {
                    customerIngredients[i] = chooseIngredients;
                    totalPrice += allIngredientAndPRice[customerIngredients[i]].getPrice();
                    break;
                }
            }
        }
    }

    public void showIngredient() {
        System.out.print("Your Ingredients :");
        for (int i = 0; i < customerIngredients.length; i++) {
            System.out.print(" " + allIngredientAndPRice[customerIngredients[i]].getName());
        }
        System.out.println("\nTotal Price : " + totalPrice);
    }

    public void chooseShakeTime() throws InterruptedException {
        do {
            System.out.print("Choose Your Shaking Time (5-15 second) : ");
            time = scn.nextInt();
            if (time >= 5 && time <= 15) {
                shakeTime = time;
            } else System.out.println("Please Try again");
        } while (time < 5 || time > 15);
    }

    public void shaking(int time) throws InterruptedException {
        System.out.println("***StART SHAKING***");
        do {
            Thread.sleep(1000);
            System.out.println("Shaking Finish in : " + time);
            time--;
        } while (time != 0);
        System.out.println("***FINISH!!***");
    }

    public void addIngredient() throws InterruptedException {
        for (int i = 0; i < customerIngredients.length; i++) {
            Thread.sleep(500);
            System.out.println("Adding ... " + allIngredientAndPRice[customerIngredients[i]].getName() + " ...");
        }
    }

    public void resetCustomerIngerdients() {
        for (int i = 0; i < customerIngredients.length; i++) {
            customerIngredients[i] = 0;
            totalPrice = 0;
        }
    }

    //    ========== MONEY TRANSACTION ==========
    public Machine(int moneyInMachine) {
        this.moneyInMachine = moneyInMachine;
    }

    public void addMoneyToMachine(int money) {
        this.moneyInMachine += money;
    }

    public void receiveMoneyFromCustomer() {
        System.out.print("Please input your money : ");
        int money = scn.nextInt();
        customerMoney += money;
        if (customerMoney < totalPrice || customerMoney < menuPrice) {
            System.out.println("*****NOT ENOUGH MONEY*****");
            System.out.println("**PLEASE INPUT MORE MONEY**");
            receiveMoneyFromCustomer();
        } else if (customerMoney > totalPrice || customerMoney > menuPrice) {
            change = customerMoney - totalPrice;
            change = customerMoney - menuPrice;
            moneyInMachine += customerMoney;
            moneyInMachine -= change;
            System.out.println("Your Change : " + change + " Bath.");
        }
//        if(customerMoney < menuPrice){
//            System.out.println("*****NOT ENOUGH MONEY*****");
//            System.out.println("**PLEASE INPUT MORE MONEY**");
//            receiveMoneyFromCustomer();
//        }

    }

}
