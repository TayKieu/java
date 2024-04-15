package bai15SuDungLopIllegalTriangleException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a,b,c;
        Scanner sc = new Scanner(System.in);
        IllegalTriangleException ie = new IllegalTriangleException();
        try{
            System.out.println("Nhap canh a: ");
            a = sc.nextDouble();
            System.out.println("Nhap canh b: ");
            b = sc.nextDouble();
            System.out.println("Nhap canh c: ");
            c = sc.nextDouble();
            try{
                ie.checkTriangle(a,b,c);
            }
            catch (IllegalTriangleException im){
                System.out.println(ie.getMessage());
            } catch (IllegalTriangleMessage e) {
                throw new RuntimeException(e);
            }
        }
        catch (Exception e){
            System.out.println("Nhập dữ liệu sai");
        }
    }
}
