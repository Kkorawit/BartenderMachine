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
    private Menu[] allMenuAndPrice = {new Menu("LEMONADE", 95, 10), new Menu("GRAPE FRUIT ROSEMARRY", 115, 10), new Menu("CHIRLEY TEMPLE", 99, 12), new Menu("STRAWBERRY LEMONADE", 85, 13), new Menu("PINEAPPLE CHERRY MOCKTAIL", 135, 11)};
    private int menuPrice;
    private int totalPrice;
    private int time;
    private int shakeTime;
    private int change;
    private int customerMoney;


    /**
     * Show all menu that machine have.
     */
    //========== CHOICE 1 ==========
    public void showMenu() {
        System.out.println("\t\t~=~=~= Menu =~=~=~");
        for (int i = 0; i < allMenuAndPrice.length; i++) {
            System.out.println( (i+1) + " " +  allMenuAndPrice[i].getName());
        }
    }

    /**
     * Let Customer choose menu
     * @throws InterruptedException
     */
    //==============================
    //========== CHOICE 2 ==========
    public void chooseMenu() throws InterruptedException {
        showMenu();
        System.out.print("Choose Menu : ");
        customerMenu = scn.nextInt()-1;
        if(customerMenu >allMenuAndPrice.length-1){
            System.out.println("===== WE DON'T HAVE THIS MENU =====");
            System.out.println("===== Please TRY AGAIN =====");
            chooseMenu();
        }
        for (int i = 0; i < allMenuAndPrice.length; i++) {
            if (customerMenu == i) {
                menuPrice = allMenuAndPrice[i].getPrice();
                break;
            }
        }
        System.out.println("=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.");
        System.out.println("Your menu is : " + allMenuAndPrice[customerMenu].getName());
        System.out.println("Price : " + menuPrice);
        System.out.println("Shaking Time : " + allMenuAndPrice[customerMenu].getShakeTime());
        System.out.println("=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.");
        totalPrice += allMenuAndPrice[customerMenu].getPrice();
        receiveMoneyFromCustomer();
        shaking(allMenuAndPrice[customerMenu].getShakeTime());
    }

    /**
     * Customer choose to create their own menu
     * @throws InterruptedException
     */
    //==============================
    //========== CHOICE 3 ==========
    public void createMenu() throws InterruptedException {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        System.out.println("This is Ingredient");
        showAllIngredient();
        chooseIngredient();
        showIngredient();
        chooseShakeTime();
        receiveMoneyFromCustomer();
        addIngredient();
        shaking(shakeTime);
    }

    /**
     * Show all ingredient that machine have
     */
    public void showAllIngredient() {
        for (int i = 0; i < allIngredientAndPRice.length; i++) {
            System.out.println((i + 1) + " : " + allIngredientAndPRice[i].getName() + " " + allIngredientAndPRice[i].getPrice() + " Bath.");
        }
    }

    /**
     * Let customer choose ingredients
     */
    public void chooseIngredient(){
        System.out.println("=*=* Please Choose ingredient *=*=");
        resetCustomerIngerdients();


        for(int i = 0; i < customerIngredients.length;i++){
            System.out.print("Inredient => " + (i+1) + " : ");
            chooseIngredients = scn.nextInt()-1;
            if(chooseIngredients > allIngredientAndPRice.length-1){
                do{
                    System.out.println("=== Don't have this ingredient ===");
                    System.out.println("=== Try again ===");
                    System.out.print("Inredient => " + (i+1) + " : ");
                    chooseIngredients = scn.nextInt()-1;
                }while (chooseIngredients > allIngredientAndPRice.length-1);
            }
            for (int c = 0; c < customerIngredients.length; c++) {
                if (customerIngredients[c] == 0) {
                    customerIngredients[c] = chooseIngredients;
                    totalPrice += allIngredientAndPRice[customerIngredients[c]].getPrice();
                    break;
                }
            }
        }
    }
    /**
     * Show all ingredient chosen by customer.
     */
    public void showIngredient() {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.print("Your Ingredients :");
        for (int i = 0; i < customerIngredients.length; i++) {
            System.out.print(" " + allIngredientAndPRice[customerIngredients[i]].getName());
        }
        System.out.println("\nTotal Price : " + totalPrice);
    }

    /**
     * Let customer choose length of shaking time.
     * @throws InterruptedException
     */
    public void chooseShakeTime() throws InterruptedException {
        do {
            System.out.print("Choose Your Shaking Time (5-15 second) : ");
            time = scn.nextInt();
            if (time >= 5 && time <= 15) {
                shakeTime = time;
            } else System.out.println("Please Try again");
        } while (time < 5 || time > 15);
    }

    /**
     * @param time length of shaking time.
     * @throws InterruptedException
     */
    public void shaking(int time) throws InterruptedException {
        if(change != customerMoney) {
            System.out.println("");

            System.out.println("*!*!* START SHAKING *!*!*");
            do {
                Thread.sleep(1000);
                System.out.println("Shaking Finish in ... " + time + " ...");
                time--;
            } while (time != 0);
            System.out.println("=~=~ FINISH!! ~=~=");
        }
    }

    /**
     * Add ingredient chosen by customer.
     * @throws InterruptedException
     */
    public void addIngredient() throws InterruptedException {
        for (int i = 0; i < customerIngredients.length; i++) {
            Thread.sleep(500);
            System.out.println("Adding ... " + allIngredientAndPRice[customerIngredients[i]].getName() + " ...");
        }
    }

    /**
     * Reset ingredient chosen by customer to all null.
     */
    public void resetCustomerIngerdients() {
        for (int i = 0; i < customerIngredients.length; i++) {
            customerIngredients[i] = 0;
            totalPrice = 0;
        }
    }
    //===========================================
    //    ========== MONEY TRANSACTION ==========
    /**
     * Creat object and add money to machine
     * @param moneyInMachine amount of money
     */
    public Machine(int moneyInMachine) {
        this.moneyInMachine = moneyInMachine;
    }

    /**
     * Add money to machine
     * @param money amount of machine for adding to.
     */
    public void addMoneyToMachine(int money) { //เพิ่มตังค์ในเครื่อง
        this.moneyInMachine += money;
    }


    /**
     * Customer inout their and calculate change if has
     */
    public void receiveMoneyFromCustomer() {
        System.out.print("Please input your money : ");
        int money = scn.nextInt();
        customerMoney += money;
        change = customerMoney - totalPrice;
        if (customerMoney < totalPrice || customerMoney < menuPrice) {
            System.out.println("*****NOT ENOUGH MONEY*****");
            System.out.println("**PLEASE INPUT MORE MONEY**");
            receiveMoneyFromCustomer();
        } else if (customerMoney > totalPrice || customerMoney > menuPrice) {
            moneyInMachine += customerMoney;
            moneyInMachine -= change;
            System.out.println("Your Change : " + change + " Bath.");

        }
        if(moneyInMachine < change){
            System.out.println("=== Not enough change ===");
            System.out.println("*=*=*=*= PLEASE CONTACT ADMINISTRATOR =*=*=*=*");
            change = customerMoney;
            System.out.println("THIS IS YOUR MONEY : " + change + " Bath.");
        }

    }
}
    //============================================