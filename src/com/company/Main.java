package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        String isDone;
        Machine mc = new Machine(1000);
        mc.addMoneyToMachine(5000);
        System.out.println("=====WELCOME TO BARTENDER MACHINE=====\n\n");
//        ==========================================================================================================================================
        do {
            System.out.println("Choice : " +
                    "\n1.Show Menu" +
                    "\n2.Choose Menu" +
                    "\n3.Creat your own menu");
            System.out.print("Your Choice : ");
            int choices = scn.nextInt();
            switch (choices) {
                case 1:
                    mc.showMenu();
                    break;
                case 2:
                    mc.chooseMenu();
                    break;
                case 3:
                    mc.createMenu();
                    break;
            }

            System.out.print("\nDone ? " + "  " + "Yes or No : ");
            isDone = scn.next().toLowerCase();
            if ((isDone.equals("no") || !isDone.equals("yes")) && (isDone.equals("yes") || !isDone.equals("no"))) {

                    System.out.println("Please Try Again");
                    System.out.print("Done ?" + "  " + "Yes or No :");
                    isDone = scn.next().toLowerCase();
            }
        } while (isDone.equals("no") );
        System.out.println("===== Thank You <3 =====");
    }
}