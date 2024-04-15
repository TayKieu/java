package bai6kethua.circleandcylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(4, "red", 5);
        Circle circle = new Circle(3, "yellow");
        System.out.println("Thuộc tính hình trụ: " + cylinder);
        System.out.println("Thuộc tính hình tròn: " + circle);
        System.out.println("Diện tích hình trụ: " + cylinder.getareaHinhTru());
        System.out.println("Diện tích hình tròn:  " + circle.getArea());
    }
}
