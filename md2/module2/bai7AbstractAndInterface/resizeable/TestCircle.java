package bai7AbstractAndInterface.resizeable;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(4);
        Circle c3 = new Circle(5,"red",true);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        c2.resize(20);
        c3.resize(10);
        System.out.println("After resize: "+c2);
        System.out.println("After resize: "+c3);
    }
}
