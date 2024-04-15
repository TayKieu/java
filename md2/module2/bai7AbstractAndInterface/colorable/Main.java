package bai7AbstractAndInterface.colorable;

public class Main {
    public static void main(String[] args) {
        Shape arr[] = new Shape[3];
        arr[0] = new Circle(4);
        arr[1] = new Rectangle(5,6);
        arr[2] = new Square(5);
        for (Shape s: arr) {
            System.out.println(s);
            if(s instanceof Colorable){
                s.howtoColor();
            }
        }
    }
}
