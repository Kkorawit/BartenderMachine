package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);
        String isDone;
        Machine mc = new Machine(0);
        mc.addMoneyToMachine(5000);
        int choices;
        System.out.println("\n\n=*=*=* WELCOME TO BARTENDER MACHINE *=*=*=\n");
//        ==========================================================================================================================================
        do {
            System.out.println("\t\t\t=-=-= Menu =-=-=" +
                    "\n\t1 > Show Menu <" +
                    "\n\t2 > Choose Menu <" +
                    "\n\t3 > Creat your own menu <");
            System.out.print("\nPlease select menu : ");
            choices = scn.nextInt();
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
            System.out.print("\nAre you done yet?" + "  " + "(Yes or No) : ");
            isDone = scn.next().toLowerCase();
                    if ((isDone.equals("no") || !isDone.equals("yes")) && (isDone.equals("yes") || !isDone.equals("no"))) {
                        do{
                        System.out.println("Please Try Again");
                        System.out.print("Done ?" + "  " + "Yes or No :");
                        isDone = scn.next().toLowerCase();
                        }while ((isDone.equals("no") || !isDone.equals("yes")) && (isDone.equals("yes") || !isDone.equals("no")));
                    }

        } while (isDone.equals("no") );
        System.out.println("===== Thank You <3 =====");
    }
}