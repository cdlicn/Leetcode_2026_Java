public class Main_1415 {
    public String getHappyString(int n, int k) {
        if (k > 3 << (n - 1)) {
            return "";
        }
        k--; // 改成从 0 开始，方便计算
        char[] res = new char[n];
        res[0] = (char) ('a' + (k >> (n - 1)));
        for (int i = 1; i < n; i++) {
            res[i] = (char) ('a' + (k >> (n - 1 - i) & 1));
            if (res[i] >= res[i - 1]) {
                res[i]++;
            }
        }
        return new String(res);
    }
}
