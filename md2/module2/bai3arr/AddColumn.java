package bai3arr;

import java.util.Scanner;

public class AddColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        for(int column = 0; column < matrix[0].length; column++){
            int total = 0;
            for(int row = 0; row < matrix.length; row++){
                total += matrix[row][column];
            }
            System.out.println("Tổng các phần tử cột" + column + " của ma trận 1 là " + total);
        }
        System.out.println("Nhập số dòng cho ma trận 2:");
        int m = sc.nextInt();
        System.out.println("Nhập số cột cho ma trận 2:");
        int n = sc.nextInt();
        int[][] matrix2 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("arr2[" + i + "]" + "[" + j + "]=");
                matrix2[i][j] = sc.nextInt();
            }
        }
        for(int column = 0; column < n; column++){
            int total = 0;
            for(int row = 0; row < m; row++){
                total += matrix2[row][column];
            }
            System.out.println("Tổng các phần tử cột " + column + " của ma trận 2 là " + total);
        }
    }
}
