package stopwatch;

public class StopWatch {
    private long starTime;
    private long endTime;

    //Hàm get và set của startTime
    public long getStarTime() {
        return starTime;
    }

    public void setStarTime(long starTime) {
        this.starTime = starTime;
    }

    //Hàm get và set của endTime
    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    //hàm lấy giá trị time của hệ thống
    void Stopwatch1() {
        this.starTime = System.currentTimeMillis();
    }


    //hàm bắt dầu
    public void start() {
        long a = System.currentTimeMillis();
        this.setStarTime(a);
    }


    //hàm kết thúc
    public void end() {
        long b = System.currentTimeMillis();
        this.setEndTime(b);
    }


    //hàm trả về
    public long getElapsedTime() {
        long trave = this.getStarTime() - this.getEndTime();
        return trave;
    }
}