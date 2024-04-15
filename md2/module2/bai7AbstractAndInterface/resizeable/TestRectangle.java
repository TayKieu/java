package bai7AbstractAndInterface.resizeable;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(5,4);
        Rectangle r3 = new Rectangle(6,7,"BLue",false);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        r2.resize(20);
        r3.resize(10);
        System.out.println("After resize: "+r2);
        System.out.println("After resize: "+r3);
    }
}
