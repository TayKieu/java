package bai15SuDungLopIllegalTriangleException;

public class IllegalTriangleException extends Throwable {
    public void checkTriangle(double a, double b, double c) throws IllegalTriangleException, IllegalTriangleMessage {
        if(a+b<=c || a+c<=b || b+c<=a){
            throw new IllegalTriangleMessage("Tam giác ko hợp lệ");
        }
        else{
            System.out.println("Tam giác hợp lệ");
        }
    }
}
