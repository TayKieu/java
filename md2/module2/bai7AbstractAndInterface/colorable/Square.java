package bai7AbstractAndInterface.colorable;

public class Square extends Shape {
    private double side = 3;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getArea() {
        return side * this.side;
    }

    public double getPerimeter() {
        return 4 * this.side;
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
    @Override
    public void howtoColor() {
        System.out.println("Color all four sides");
    }
}
