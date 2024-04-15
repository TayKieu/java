package Bai4classandobj.classfan;

public class Fan {
    final int Slow = 1;
    final int Medium = 2;
    final int Fast = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;


    public Fan() {
        this.speed = Slow;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    //speed
    public int getSlow() {
        return Slow;
    }

    public int getMedium() {
        return Medium;
    }

    public int getFast() {
        return Fast;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //công tắc
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    //radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //Hàm so sánh on == true hoặc false bằng toán tử ba ngôi để thực thi
    @Override
    public String toString() {
        return this.on ?
                "Fan is on " + " ,speed:" + getSpeed() + ", radius:" + getRadius() + ", color:" + getColor() :
                "Fan is off " + " ,radius:" + getRadius() + ", color:" + getColor();
    }
}
