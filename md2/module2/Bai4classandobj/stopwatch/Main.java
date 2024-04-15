package Bai4classandobj.stopwatch;

public class Main {
    public static void main(String[] args) {
        stopwatch.StopWatch ojb = new stopwatch.StopWatch();
        ojb.start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ojb.end();
        System.out.println("The Elapsed time is: " + ojb.getElapsedTime() + " milisec");
    }
}
