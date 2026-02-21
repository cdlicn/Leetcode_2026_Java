public class Main_762 {

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            int tmp = i, cnt = 0;
            while (tmp != 0) {
                cnt += tmp & 1;
                tmp >>= 1;
            }
            if (isPrime(cnt)) {
                res++;
            }
        }
        return res;
    }
}
