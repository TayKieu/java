package bai7AbstractAndInterface.resizeable;

public class TestSquare {
    public static void main(String[] args) {
        Square s1 = new Square();
        Square s2 = new Square(4);
        Square s3 = new Square(5,"Yellow",true);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s2.resize(30);
        s3.resize(35);
        System.out.println("After resize: "+s2);
        System.out.println("After resize: "+s3);
    }
}
