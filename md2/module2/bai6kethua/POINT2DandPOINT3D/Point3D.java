package bai6kethua.POINT2DandPOINT3D;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    Point3D() {
    }

    Point3D(float x,float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float array2[] = new float[3];
        array2[0] = x;
        array2[1] = y;
        array2[2] = z;
        return array2;
    }

    public void setXYZ(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
