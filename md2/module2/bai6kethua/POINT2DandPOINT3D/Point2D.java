package bai6kethua.POINT2DandPOINT3D;

public class Point2D {
    public float x = 0.0f;
    public float y = 0.0f;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float array[] = new float[2];
        array[0] = x;
        array[1] = y;
        return array;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    Point2D() {
    }

    ;

    Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
