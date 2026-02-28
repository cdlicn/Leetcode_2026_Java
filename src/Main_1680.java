public class Main_1680 {
    public int concatenatedBinary(int n) {
        int MOD = 1000000007;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int len = 32 -  Integer.numberOfLeadingZeros(i);
            res = ((res << len) | i) % MOD;
        }
        return (int) res;
    }
}
