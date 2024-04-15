package bai6kethua.circleandcylinder;

public class Cylinder extends Circle{
    public double height;
    public Cylinder() {

    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color,double height) {
        super(radius, color);
        this.height=height;
    }
    public double getareaHinhTru(){
        return super.getArea() * height;
    }

    @Override
    public String toString() {
        return super.toString() + " Height: "+getHeight();
    }
}
