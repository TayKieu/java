package bai6kethua.POINTvaMOVEABLEPOINT;

public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveable = new MoveablePoint(7,4,2,3);
        System.out.println(moveable);
        System.out.println(moveable.move());
    }
}
