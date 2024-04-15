package bai10StackandQueue.Optional.KiemTraDauNgoac;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //tạo stack rỗng
        Stack<String> stack = new Stack<>();
        //cho người dùng nhập
        System.out.println("Nhập chuỗi ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        //Nếu ngoặc bên trái đưa vào trong stack
        //tạo 1 biến check có rỗng ko,mặc định true
        boolean check = true;
        //thuật toán
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(') {
                stack.push(String.valueOf(text.charAt(i)));
            } else if (text.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    check = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            check = false;
        }
        if(check==true){
            System.out.println("Đúng");
        }else System.out.println("Sai");
    }
}
