public class Main_3783 {
    public int mirrorDistance(int n) {
        int tmp = n, rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return Math.abs(tmp - rev);
    }
}
