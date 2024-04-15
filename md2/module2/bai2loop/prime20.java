package bai2loop;

public class prime20 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; ; i++) {
            if (isPrime(i)) {
                System.out.print(i + "  ");
                count++;
                if(count==20){
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
