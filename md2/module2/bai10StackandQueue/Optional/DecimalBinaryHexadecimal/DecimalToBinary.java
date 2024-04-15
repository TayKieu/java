package bai10StackandQueue.Optional.DecimalBinaryHexadecimal;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public void convertToBinary(int num){
        Stack stack = new Stack();
        while (num > 0){
            int d = num % 2;
            stack.push(d);
            num /= 2;
        }
        while (!(stack.isEmpty())){
            System.out.println(stack.pop());
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số thập phân cần chuyển đổi: ");
        int decimalNumber = sc.nextInt();

        System.out.println("Hệ nhị phân của " + decimalNumber +" là :");

        new DecimalToBinary().convertToBinary(decimalNumber);

    }
}
