package baimau.util;

import baimau.models.ATM;
import baimau.models.CreditCard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static final String blank = "";
        final static String CARD_PATH = "D:\\java\\src\\baimau\\card.txt";
        private static void writeListToTXT(List<String> list, String path, boolean append){
            File file = new File(path);
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            try{
                fileWriter = new FileWriter(file,append);
                bufferedWriter = new BufferedWriter(fileWriter);
                for(String string : list){
                    bufferedWriter.write(string);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            }
            catch (IOException err){
                System.out.println("\nError: Can not write file.\n");
            }
        }
        private static List<String> readTXTToList(String path){
            List<String> list = new ArrayList<>();
            File file = new File(path);
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            try{
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                String line = null;
                while ((line = bufferedReader.readLine())!= null){
                    list.add(line);
                }
                bufferedReader.close();
                fileReader.close();
            }
            catch (IOException err){
                System.out.println("Lỗi đọc file");
            }
            return list;
        }
        public static void writeATMListToTXT(List<ATM> atmList, boolean append){
            List<String> string = new ArrayList<>();
            for(ATM atm : atmList){
                string.add(atm.getInforToTXT());
            }
            writeListToTXT(string, CARD_PATH , append);

        }
    public static void writeCreditCardListToTXT(List<CreditCard> creditcardList, boolean append){
        List<String> string = new ArrayList<>();
        for(CreditCard creditCard : creditcardList){
            string.add(creditCard.getInforToTXT());
        }
        writeListToTXT(string, CARD_PATH , append);
    }
    public static List<ATM> readATMListFromTXT(){
        List<String> list = readTXTToList(CARD_PATH);
        List<ATM> atmList = new ArrayList<>();
        String[] arr = null;
        for(int i = 0; i< list.size(); i++) {
            arr = list.get(i).split(",");
            ATM atm = new ATM(arr[0],arr[1], arr[2], arr[3], Integer.parseInt(arr[4]));
            atmList.add(atm);
        }
        return atmList;
    }
    public static List<CreditCard> readCreditCardListFromTXT(){
        List<String> list = readTXTToList(CARD_PATH);
        List<CreditCard> creditCardList = new ArrayList<>();
        String[] arr = null;
        for(int i = 0; i< list.size(); i++){
            arr = list.get(i).split(",");
            CreditCard creditCard = new CreditCard(arr[0],arr[1], arr[2], arr[3],Integer.parseInt(arr[4]),Integer.parseInt(arr[5]));
            creditCardList.add(creditCard);
        }
        return creditCardList;
    }
}
