package bai3arr;

import java.util.Scanner;

public class Sumsoduongcheochinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[3][3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Nhập phần tử tại vị trí " + "[" + i + "]" + "[" + j + "]" + ":");
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("Tổng số trên đường chéo chính là :" + sum);
    }
}
