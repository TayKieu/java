package bai3arr;

import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[][] = {{1, 2, 3}, {4, 25, 6}, {7, 8, 9}, {10, 11, 12}};
        int max = arr1[0][0];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr1[i][j] > max) {
                    max = arr1[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng 1:" + max);
        System.out.println("Nhập số dòng cho mảng 2:");
        int m = sc.nextInt();
        System.out.println("Nhập số cột cho mảng 2:");
        int n = sc.nextInt();
        int arr2[][] = new int[m][n];
        System.out.println("Nhập các phần tử cho ma trận 2:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("arr2[" + i + "]" + "[" + j + "]=");
                arr2[i][j] = sc.nextInt();
            }
        }
        int max2 = arr2[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr2[i][j] > max2) {
                    max2 = arr2[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng 2: " + max2);
    }
}
