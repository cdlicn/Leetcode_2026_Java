public class Main_868 {
    public int binaryGap(int n) {
        int res = 0;
        n /= (n & -n) * 2;
        while (n > 0) {
            int gap = Integer.numberOfTrailingZeros(n) + 1;
            res = Math.max(res, gap);
            n >>= gap;
        }
        return res;
    }
}
