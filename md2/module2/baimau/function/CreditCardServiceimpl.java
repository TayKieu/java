package baimau.function;

import baimau.models.ATM;
import baimau.models.CreditCard;
import baimau.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreditCardServiceimpl implements CreditCardService {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void signUp() {

        String sothe;
        while (true) {
            System.out.println("\n Nhập số thẻ: ");
            String str = sc.nextLine();
            if (str.length() != 12) {
                System.out.println("\n Error: Số thẻ phải có 12 số");
                continue;
            } else {
                sothe = str;
                break;
            }
        }

        System.out.println("\nNhập tên:");
        String name = sc.nextLine();
        String cccd;
        while (true) {
            System.out.println("\n Nhập số CCCD: ");
            String str = sc.nextLine();
            if (str.length() != 12) {
                System.out.println("\n Error: CCCD phải có 12 số");
                continue;
            } else {
                cccd = str;
                break;
            }
        }
        System.out.println("\n Nhập địa chỉ: ");
        String addr = sc.nextLine();
        Integer duno = 0;
        System.out.println("\n Nhập hạn mức:");
        Integer hanmuc = sc.nextInt();
        CreditCard creditCard = new CreditCard(sothe, name, cccd, addr, duno, hanmuc);
        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardList.add(creditCard);
        ReadAndWriteFile.writeCreditCardListToTXT(creditCardList, true);
    }

    @Override
    public void edit() {
        List<CreditCard> creditCardList = ReadAndWriteFile.readCreditCardListFromTXT();
        show();
        int index;
        while (true) {
            try {
                System.out.println("\nChọn vị trí số thẻ cần sửa:");
                index = Integer.parseInt(sc.nextLine());
            } catch (Exception err) {
                System.out.println("\nError: Could not parst to number.\nTry agian!\n");
                continue;
            }
            if (index <= 0 || index > creditCardList.size()) {
                System.out.println("\nError: Invalid employee.\nTry agian!\n");
                continue;
            }
            break;
        }
        String sothe;
        while (true) {
            System.out.println("\n Nhập số thẻ: ");
            String str = sc.nextLine();
            if (str.length() != 12) {
                System.out.println("\n Error: Số thẻ phải có 12 số");
                continue;
            } else {
                sothe = str;
                break;
            }
        }
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();

        String cccd;
        while (true) {
            System.out.println("\n Nhập số CCCD: ");
            String str = sc.nextLine();
            if (str.length() != 12) {
                System.out.println("\n Error: CCCD phải có 12 số");
                continue;
            } else {
                cccd = str;
                break;
            }
        }
        System.out.println("\n Nhập địa chỉ: ");
        String addr = sc.nextLine();
        creditCardList.get(index - 1).setSothe(sothe);
        creditCardList.get(index - 1).setName(name);
        creditCardList.get(index - 1).setCCCD(cccd);
        creditCardList.get(index - 1).setAddress(addr);
        ReadAndWriteFile.writeCreditCardListToTXT(creditCardList, false);
    }

    @Override
    public void show() {
        List<CreditCard> creditCardList = ReadAndWriteFile.readCreditCardListFromTXT();
        System.out.println("\nShow Information ");
        for (int i = 0; i < creditCardList.size(); i++) {
            System.out.println((i + 1) + "." + creditCardList.get(i));
        }
        System.out.println();
    }

    public static void payCreditCard() {
        List<CreditCard> creditCardList = ReadAndWriteFile.readCreditCardListFromTXT();
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        for (CreditCard creditcard : creditCardList) {
            if(creditcard.getSothe() == cardNumber){
                System.out.println("Nhập số tiền cần thanh toán: ");
                int pay = scanner.nextInt();
                if((creditcard.getDuno()+pay) <= creditcard.getHanmuc()){
                    creditcard.setDuno(creditcard.getDuno()+pay);
                }
                else {
                    System.out.println("Hạn mức quý khách không đủ!!");
                }
            }
            else {
                System.out.println("Không tìm thấy số thẻ credit");
            }
        }
    }
    public static void findCreditCard(){
        List<CreditCard> creditCardList = ReadAndWriteFile.readCreditCardListFromTXT();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên chủ thẻ cần tìm");
        String name = scanner.nextLine();
        for (CreditCard creditCard: creditCardList) {
            if(creditCard.getName().trim().lastIndexOf(name) >=0){
                creditCard.toString();
            }
        }
    }
    public static void loadCreditCard(){
        List<CreditCard> creditCardList = ReadAndWriteFile.readCreditCardListFromTXT();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thẻ muốn nạp tiền: ");
        String cardNumber = scanner.nextLine();
        for (CreditCard creditCard: creditCardList) {
            if(creditCard.getSothe() == cardNumber){
                System.out.println("Nhập số tiền muốn nạp: ");
                int money = scanner.nextInt();
                creditCard.setDuno(creditCard.getDuno()-money);
            }
            else {
                System.out.println("Không tìm thấy thẻ credit");
            }
        }
    }
    public static void deleteCreditCard(){
        List<CreditCard> creditCardList = ReadAndWriteFile.readCreditCardListFromTXT();
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        for(int i = 0; i< creditCardList.size();i++){
            if((creditCardList.get(i).getSothe() == cardNumber) && (creditCardList.get(i).getHanmuc() <= 0)){
                creditCardList.remove(i);
                break;
            }
        }
    }
}
