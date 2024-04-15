package bai3arr;


import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        int count = 0;
        int x;
        String arr = "KieuDuongTay";
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào kí tự cần đếm:");
        x = sc.next().charAt(0);
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == x) {
                count++;
            }
        }

        System.out.println("có " + count + " kí tự trong chuỗi ");
    }
}
