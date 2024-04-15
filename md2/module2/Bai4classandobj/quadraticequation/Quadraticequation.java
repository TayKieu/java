package Bai4classandobj.quadraticequation;

import java.util.Scanner;

public class Quadraticequation {
    private double a;
    private double b;
    private double c;

    public Quadraticequation() {
    }

    ;

    public Quadraticequation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập hệ số bậc 2, a = ");
        double a = sc.nextDouble();
        System.out.print("Nhập hệ số bậc 1, b = ");
        double b = sc.nextDouble();
        System.out.print("Nhập hằng số tự do, c = ");
        double c = sc.nextDouble();
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public double getRoot() {
        return (-b / (2 * a));
    }

    public double getRoot1() {

        return ((-b + Math.sqrt(getDiscriminant())) / 2 * a);
    }

    public double getRoot2() {
        return ((-b - Math.sqrt(getDiscriminant())) / 2 * a);
    }

    public void Value() {
        if (getDiscriminant() == 0) {
            System.out.println("Phương trinh có 1 nghiệm duy nhất: " + getRoot());
        } else if (getDiscriminant() > 0) {
            System.out.println("Phương trình có 2 nghiệm phân biệt:");
            System.out.println("x1=" + getRoot1());
            System.out.println("x2=" + getRoot2());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}


