package bai10StackandQueue.Optional.CheckPalindrome;

import java.util.Scanner;
import java.util.Stack;

public class KiemTraDoiXungSuDungWhileFor {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi muốn kiểm tra: ");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String reverseString = "";
        int length = inputString.length();
        for(int i = length-1; i >=0; i-- ){
            reverseString += inputString.charAt(i);
        }
        if(inputString.equals(reverseString)){
            System.out.println("Đây là chuỗi đối xứng");
        }
        else {
            System.out.println("Đây ko phải là chuỗi đối xứng");
        }
    }
}
