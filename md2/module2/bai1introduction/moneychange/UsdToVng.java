package bai1introduction.moneychange;

import java.util.Scanner;

public class UsdToVng {
    public static void main(String[] args) {
        double usd;
        System.out.println("Rate = 23000 VNG/USD");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền trị giá USD: ");
        usd = sc.nextDouble();
        double change = usd * 23000;
        System.out.println("Giá trị VNG là : " +change);
    }
}
