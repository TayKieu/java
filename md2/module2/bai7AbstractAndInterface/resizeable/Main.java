package bai7AbstractAndInterface.resizeable;

public class Main {
    public static void main(String[] args) {
        Shape arr[]=new Shape[3];
        arr[0]=new Rectangle(5,4);
        arr[1]=new Circle(6);
        arr[2]=new Square(7);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        arr[0].resize(20);
        arr[1].resize(10);
        arr[2].resize(15);
        System.out.println("After increase: "+arr[0]);
        System.out.println("After increase: "+arr[1]);
        System.out.println("After increase: "+arr[2]);
    }
}
