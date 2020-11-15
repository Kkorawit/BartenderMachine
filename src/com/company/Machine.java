package com.company;

import java.util.Scanner;
import java.lang.Thread;


public class Machine {
    private int moneyInMachine; //เงินในตู้
    Scanner scn = new Scanner(System.in);
    private int chooseIngredients;//วัตถุดิบที่ลูกค้าเลือก
    private int[] customerIngredients = new int[5];//เก็บตัวแปรวัตถุดิบที่ลูกค้าเลือก
    private int customerMenu;//รับค่าเมนูที่ลูกค้าเลือก
    private Ingredient[] allIngredientAndPRice = {new Ingredient("WATER", 10), new Ingredient("LEMON", 20), new Ingredient("BROWNSUGAR", 15), new Ingredient("COLDWATER", 13), new Ingredient("ICE", 8), new Ingredient("LIMEADE", 30), new Ingredient("STRAWBERRY", 27), new Ingredient("LEMONJUICE", 29), new Ingredient("MINT", 12), new Ingredient("POMEGRANATESYRUP", 34), new Ingredient("LEMONSODA", 26), new Ingredient("CHERRYSYRUP", 42), new Ingredient("ROSEMARRYSYRUP", 24), new Ingredient("PINEAPPLEJUICE", 28)};
    private Menu[] allMenuAndPrice = {new Menu("LEMONADE", 50, 10), new Menu("GRAPE FRUIT ROSEMARRY", 60, 10), new Menu("CHIRLEY TEMPLE", 70, 70), new Menu("STRAWBERRY LEMONADE", 80, 10), new Menu("PINEAPPLE CHERRY MOCKTAIL", 10, 50)};
    private int menuPrice;//ดึงค่าราคาเมนูที่ลูกค้าเลือกจาก allMenuAndPrice
    private int totalPrice;//ราคาทั้งหมดจากเมนูหรือวัตถุดิบ
    private int time;//เวลาที่ลูกค้าต้องการในการเขย่าผสมวัตถุดิบ
    private int shakeTime;//เวลาเขย่า
    private int change;//เงินทอน
    private int customerMoney;//เงินที่ลูกค้าใส่เข้ามา

    //========== CHOICE 1 ========== แสดงเมนู
    public void showMenu() {
        System.out.println("========== MENU ==========");
        for (int i = 0; i < allMenuAndPrice.length; i++) {
            System.out.println( (i+1) + " " +  allMenuAndPrice[i].getName());
        }
    }
    //==============================
    //========== CHOICE 2 ========== แสดงเมนูและให้ลูกค้าเลือกเมนู
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
        System.out.println("Your menu is : " + allMenuAndPrice[customerMenu].getName());
        System.out.println("Price : " + menuPrice);
        System.out.println("Shaking Time : " + allMenuAndPrice[customerMenu].getShakeTime());
        totalPrice += allMenuAndPrice[customerMenu].getPrice();
        receiveMoneyFromCustomer();
        shaking(allMenuAndPrice[customerMenu].getShakeTime());
    }
    //==============================
    //========== CHOICE 3 ==========
    public void createMenu() throws InterruptedException {//ให้ลูกค้าสร้างเมนูเอง
        System.out.println("This is Ingredient");
        showAllIngredient(); // แสดงวัตถุดิบทั้งหมด
        chooseIngredient(); //เลือกวัตถุดิบที่ลูกค้าต้องการ
        showIngredient(); //แสดงวัตถุดิบที่ลูกค้าเลือก
        chooseShakeTime(); //เลือกเวลาเขย่า
        receiveMoneyFromCustomer(); //รับเงินจากลูกค้า
        addIngredient(); //ใช้แสดงว่า
        shaking(shakeTime); //แสดงให้ดูว่าเขย่าอีกกี่วิ
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
            if (chooseIngredients > allIngredientAndPRice.length-1) {
                System.out.println("===== DON'T HAVE THIS INGREDIENT =====");
                System.out.println("===== PLEASE TRY AGAIN =====");
                chooseIngredient();
              }
            }
            for (int i = 0; i < customerIngredients.length; i++) {
                if (customerIngredients[i] == 0) {
                    customerIngredients[i] = chooseIngredients;
                    totalPrice += allIngredientAndPRice[customerIngredients[i]].getPrice();
                    break;
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
        System.out.println("***START SHAKING***");
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

    public void resetCustomerIngerdients() {//ทำให้วัตถุดิบที่ลูกค้าเลือกเป็น 0
        for (int i = 0; i < customerIngredients.length; i++) {
            customerIngredients[i] = 0;
            totalPrice = 0;
        }
    }
    //===========================================
    //    ========== MONEY TRANSACTION ==========
    public Machine(int moneyInMachine) {
        this.moneyInMachine = moneyInMachine;
    }

    public void addMoneyToMachine(int money) { //เพิ่มตังค์ในเครื่อง
        this.moneyInMachine += money;
    }

    public void receiveMoneyFromCustomer() { //สำหรับรับเงินและคิดเงิน
        System.out.print("Please input your money : ");
        int money = scn.nextInt();
        customerMoney += money;
        if (customerMoney < totalPrice || customerMoney < menuPrice) {
            System.out.println("*****NOT ENOUGH MONEY*****");
            System.out.println("**PLEASE INPUT MORE MONEY**");
            receiveMoneyFromCustomer();
        } else if (customerMoney > totalPrice || customerMoney > menuPrice) {
            change = customerMoney - totalPrice;
           // change = customerMoney - menuPrice;
            moneyInMachine += customerMoney;
            moneyInMachine -= change;
            System.out.println("Your Change : " + change + " Bath.");
        }
    }
    public void checkMoney(){
        System.out.println(moneyInMachine);
    } // ดูเงินในตู้
}
    //============================================