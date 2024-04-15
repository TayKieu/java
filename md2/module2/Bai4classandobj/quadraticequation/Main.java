package Bai4classandobj.quadraticequation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("input a: ");
        a = Double.parseDouble(sc.nextLine());
        System.out.println("input b: ");
        b = Double.parseDouble(sc.nextLine());
        System.out.println("input c: ");
        c = Double.parseDouble(sc.nextLine());
        Quadraticequation value = new Quadraticequation(a, b, c);
        value.Value();
    }
}
