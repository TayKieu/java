package bai7AbstractAndInterface.colorable;

public class TestSquare {
    public static void main(String[] args) {
        Square s1 = new Square();
        Square s2 = new Square(4);
        Square s3 = new Square(5,"blue",true);
        s3.howtoColor();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
