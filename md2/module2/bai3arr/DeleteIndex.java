package bai3arr;

import java.util.Scanner;

public class DeleteIndex {
    public static void main(String[] args) {
        System.out.println("Nhập số lượng phần tử của mảng");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Nhập phần tử cần xóa: ");
        int x = scanner.nextInt();
        for (int i = 0; i<arr.length;i++){
            if(arr[i] == x){
                arr[i] = arr[i+1];
            }
            else {
                System.out.println(arr[i]);
            }
        }
    }

}
