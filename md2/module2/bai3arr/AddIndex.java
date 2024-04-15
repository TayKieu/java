package bai3arr;

import java.util.Scanner;

public class AddIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        System.out.println("Nhập số lượng phần tử hiện tại của mảng:");
        int n = sc.nextInt();
        for (int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Nhập vị trí cần chèn: ");
        int x = sc.nextInt();
        if(x<0 || x>arr.length) {
            System.out.println("Vị trí ko có trong mảng");
        }
        else {
            System.out.println("Nhập số cần chèn:");
            int y = sc.nextInt();
            for (int i = n; i > x; i--){
                arr[i] = arr[i-1];
            }
            n++;
            arr[x] = y;
            for(int i = 0; i<n;i++){
                System.out.println(arr[i]);
            }
        }
    }
}
