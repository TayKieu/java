package casestudy.controllers;

import jdk.nashorn.internal.ir.SplitReturn;

import java.util.Scanner;

public class FuramaController {
    public static void displayMainMenu() {
       Scanner sc = new Scanner(System.in);
       while (true){
           int mainOption = 0;
           try{
               System.out.println("\t\t" + " MENU " + "\t\t\t");
               System.out.println("1. Employee Management");
               System.out.println("2. Customer Management");
               System.out.println("3. Facility Management");
               System.out.println("4. Booking Management");
               System.out.println("5. Promotion Management");
               System.out.println("6. Exit ");
           }
           catch (NumberFormatException err){
               System.out.println("\nError: Could not parst option to number!\nTry agian...\n");
               continue;
           }
           switch (mainOption){
               case 1:
               case 2:
               case 3:
               case 4:
               case 5:
               case 6: return;
               default:
                   System.out.println("Error: Your option do not match!\nTryr agian...\n");
           }
       }
    }
    private static void manageEmployee() {
        Scanner sc = new Scanner(System.in);
        while(true){
            int employeeOption = 0;
            try{
                System.out.println("\t\t" + " Employee Management: " + "\t\t\t");
                System.out.println("1. Display list employees");
                System.out.println("2. Add new employee");
                System.out.println("3. Edit employee");
                System.out.println("4. Return main menu");
                employeeOption = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException err){
                System.out.println("\nError: Could not parst option to number!\nTry agian...\n");
                continue;
            }
            switch (employeeOption){
                case 1:
                case 2:
                case 3:
                case 4: return;
                default:
                    System.out.println("Error: Your option do not match!\nTryr agian...\n");
            }
            if(employeeOption >=1 && employeeOption <=3){
                break;
            }
        }
    }
    private static void manageCustomer(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int customerOption = 0;
            try{
                System.out.println("\t\t" + " Customer Management: " + "\t\t\t");
                System.out.println("1. Display list customers");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Return main menu");
                customerOption = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException err){
                System.out.println("\nError: Could not parst option to number!\nTry agian...\n");
                continue;
            }
            switch (customerOption){
                case 1:
                case 2:
                case 3:
                case 4: return;
                default:
                    System.out.println("Error: Your option do not match!\nTryr agian...\n");
            }
            if(customerOption >=1 && customerOption <=3){
                break;
            }
        }
    }
    private static void manageFacility(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int facilityOption = 0;
            try{
                System.out.println("\t\t" + " Facility Management: " + "\t\t\t");
                System.out.println("1. Display list facility");
                System.out.println("2. Add new facility");
                System.out.println("3. Display list facility maintenance");
                System.out.println("4. Return main menu");
                facilityOption = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException err){
                System.out.println("\nError: Could not parst option to number!\nTry agian...\n");
                continue;
            }
            switch (facilityOption){
                case 1:
                case 2:
                case 3:
                case 4: return;
                default:
                    System.out.println("Error: Your option do not match!\nTryr agian...\n");
            }
            if(facilityOption >=1 && facilityOption <=3){
                break;
            }
        }
    }
    private static void manageBooking(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int bookingOption = 0;
            try{
                System.out.println("\t\t" + " Booking Management: " + "\t\t\t");
                System.out.println("1. Add new booking");
                System.out.println("2. Display list booking");
                System.out.println("3. Display list facility maintenance");
                System.out.println("4. Return main menu");
                bookingOption = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException err){
                System.out.println("\nError: Could not parst option to number!\nTry agian...\n");
                continue;
            }
            switch (bookingOption){
                case 1:
                case 2:
                case 3:
                case 4: return;
                default:
                    System.out.println("Error: Your option do not match!\nTryr agian...\n");
            }
            if(bookingOption >=1 && bookingOption <=3){
                break;
            }
        }
    }
    private static void managePromotion(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int promotionOption = 0;
            try{
                System.out.println("\t\t" + " Promotion Management: " + "\t\t\t");
                System.out.println("1. Display list customers use service");
                System.out.println("2. Display list customers get voucher");
                System.out.println("4. Return main menu");
                promotionOption = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException err){
                System.out.println("\nError: Could not parst option to number!\nTry agian...\n");
                continue;
            }
            switch (promotionOption){
                case 1:
                case 2:
                case 3:
                case 4: return;
                default:
                    System.out.println("Error: Your option do not match!\nTryr agian...\n");
            }
            if(promotionOption >=1 && promotionOption <=3){
                break;
            }
        }
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
