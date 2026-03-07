public class Main_1888 {
    public int minFlips(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int res = n;
        int cnt = 0;
        for (int i = 0; i < n * 2 - 1; i++) {
            if (s[i % n] % 2 != i % 2) {
                cnt++;
            }
            int left = i - n + 1;
            if (left < 0) {
                continue;
            }
            res = Math.min(res, Math.min(cnt, n - cnt));
            if (s[left] % 2 != left % 2) {
                cnt--;
            }
        }
        return res;
    }
}
