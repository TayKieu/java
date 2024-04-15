package bai3arr;

import java.util.Arrays;
import java.util.Scanner;

public class CombineArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[]=new int[5];
        int arr2[] = new int[5];
        int arr3 [] = new int[10];
        int pos = 0;
        System.out.println("Nhập các phần tử cho mảng 1");
        for(int i = 0; i< arr1.length;i++){
            arr1[i] = sc.nextInt();
        }
        System.out.println("Nhập các phần tử cho mảng 2");
        for(int i = 0; i<arr2.length;i++){
            arr2[i] = sc.nextInt();
        }
        for(int i:arr1){
            arr3[pos]=i;
            pos++;
        }
        for(int i:arr2){
            arr3[pos]=i;
            pos++;
        }
        System.out.println(Arrays.toString(arr3));
    }
}
