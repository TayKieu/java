package baimau.function;

import baimau.models.ATM;
import baimau.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMServiceImpl implements ATMService {
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
        Integer sodu = 0;
        ATM atm = new ATM(sothe, name, cccd, addr, sodu);
        List<ATM> atmList = new ArrayList<>();
        atmList.add(atm);
        ReadAndWriteFile.writeATMListToTXT(atmList, true);
    }

    @Override
    public void edit() {
        List<ATM> atmList = ReadAndWriteFile.readATMListFromTXT();
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
            if (index <= 0 || index > atmList.size()) {
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
        atmList.get(index - 1).setSothe(sothe);
        atmList.get(index - 1).setName(name);
        atmList.get(index - 1).setCCCD(cccd);
        atmList.get(index - 1).setAddress(addr);
        ReadAndWriteFile.writeATMListToTXT(atmList, false);
    }


    @Override
    public void show() {
        List<ATM> atmList = ReadAndWriteFile.readATMListFromTXT();
        System.out.println("\nShow Information ");
        for (int i = 0; i < atmList.size(); i++) {
            System.out.println((i + 1) + "." + atmList.get(i));
        }
        System.out.println();
    }

    public static void payATM() {
        List<ATM> atmList = ReadAndWriteFile.readATMListFromTXT();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thẻ sử dụng: ");
        String cardNumber = scanner.nextLine();
        for (ATM index : atmList) {
            if(index.getSothe() == cardNumber){
                System.out.println("Nhập số tiền cần thanh toán: ");
                int pay = scanner.nextInt();
                if(index.getSodu() >= pay){
                    index.setSodu(index.getSodu() - pay);
                }
                else {
                    System.out.println("Số tiền quý khách không đủ !!");
                }
            }
            else {
                System.out.println("Không có số thẻ này !!");
            }
        }

    }
    public static void loadATM(){
        List<ATM> atmList = ReadAndWriteFile.readATMListFromTXT();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thẻ muốn nạp: ");
        String cardNumber = scanner.nextLine();
        for (ATM atm : atmList) {
            if(atm.getSothe() == cardNumber){
                System.out.println("Nhập số tiền muốn nạp");
                int money = scanner.nextInt();
                atm.setSodu(atm.getSodu()+money);
                break;
            }
        }
    }
    public static void findATM(){
        List<ATM> atmList = ReadAndWriteFile.readATMListFromTXT();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (ATM atm: atmList) {
            if(atm.getName().trim().lastIndexOf(name) >= 0){
                atm.toString();
            }
        }
    }
    public static void deleteCardATM(){
        List<ATM> atmList = ReadAndWriteFile.readATMListFromTXT();
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        for(int i = 0; i < atmList.size();i++){
            if(atmList.get(i).getSothe() == cardNumber){
                atmList.remove(i);
                break;
            }
        }
    }

}

