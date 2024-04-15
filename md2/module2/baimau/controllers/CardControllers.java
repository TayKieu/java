package baimau.controllers;

import baimau.function.*;
import baimau.models.CreditCard;
import baimau.util.ReadAndWriteFile;

import java.util.Scanner;

public class CardControllers {
    private static ATMService atmService = new ATMServiceImpl();
    private static CreditCardService creditCardService = new CreditCardServiceimpl();
    public static void displayMainMenu() {
        Scanner sc = new Scanner(System.in);
        while (true){
            int mainOption = 0;
            try{
                System.out.println("\t\t" + " Chọn thẻ thanh toán " + "\t\t\t");
                System.out.println("1. ATM");
                System.out.println("2. Credit Card");
                System.out.println("3. Exit ");
                mainOption = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException err){
                System.out.println("\nError: Could not parst option to number!\nTry agian...\n");
                continue;
            }
            switch (mainOption){
                case 1: manageATM();
                case 2: manageCreditCard();
                case 3: return;

                default:
                    System.out.println("Error: Your option do not match!\nTryr agian...\n");
            }
        }
    }
    private static void manageATM() {
        Scanner sc = new Scanner(System.in);
        while(true){
            int atmOption = 0;
            try{
                System.out.println("\t\t" + " ATM " + "\t\t\t");
                System.out.println("1. Đăng ký thẻ");
                System.out.println("2. Đọc file");
                System.out.println("3. Thanh toán bằng thẻ");
                System.out.println("4. Nộp tiền vào thẻ");
                System.out.println("5. Tìm card");
                System.out.println("6. Hủy thẻ");
                System.out.println("7. Chuyển khoản");
                System.out.println("8. Return main menu");
                atmOption = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException err){
                System.out.println("\nError: Could not parst option to number!\nTry agian...\n");
                continue;
            }
            switch (atmOption){
                case 1: atmService.signUp();break;
                case 2: atmService.show();break;
                case 3:
                case 8: break;
                default:
                    System.out.println("Error: Your option do not match!\nTry again...\n");
            }
        }
    }
    private static void manageCreditCard(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int creditCardOption = 0;
            try{
                System.out.println("\t\t" + " Credit Card: " + "\t\t\t");
                System.out.println("1. Đăng ký thẻ");
                System.out.println("2. Đọc file");
                System.out.println("3. Thanh toán bằng thẻ");
                System.out.println("4. Nộp tiền vào thẻ");
                System.out.println("5. Tìm card");
                System.out.println("6. Hủy thẻ");
                System.out.println("7. Chuyển khoản");
                System.out.println("8. Return main menu");
                creditCardOption = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException err){
                System.out.println("\nError: Could not parst option to number!\nTry agian...\n");
                continue;
            }
            switch (creditCardOption){
                case 1: creditCardService.signUp();break;
                case 2:creditCardService.show();break;
                case 3:
                case 8: break;
                default:
                    System.out.println("Error: Your option do not match!\nTryr agian...\n");
            }
        }
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
