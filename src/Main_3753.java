// TODO 3753. 范围内总波动值 II
public class Main_3753 {
    public long totalWaviness(long num1, long num2) {
        char[] lowS = Long.toString(num1).toCharArray();
        char[] highS = Long.toString(num2).toCharArray();
        int n = highS.length;
        long[][][][] memo = new long[n][n - 1][3][10]; // 一个数至多包含 n-2 个峰或谷
        return dfs(0, 0, 0, 0, true, true, lowS, highS, memo);
    }

    private long dfs(int i, int waviness, int lastCmp, int lastDigit, boolean limitLow, boolean limitHigh, char[] lowS, char[] highS, long[][][][] memo) {
        if (i == highS.length) {
            return waviness;
        }
        if (!limitLow && !limitHigh && memo[i][waviness][lastCmp + 1][lastDigit] > 0) {
            return memo[i][waviness][lastCmp + 1][lastDigit] - 1;
        }

        int diffLh = highS.length - lowS.length;
        int lo = limitLow && i >= diffLh ? lowS[i - diffLh] - '0' : 0;
        int hi = limitHigh ? highS[i] - '0' : 9;

        long res = 0;
        boolean isNum = !limitLow || i > diffLh; // 前面是否填过数字
        for (int d = lo; d <= hi; d++) {
            // 当前填的数不是最高位，cmp 才有意义
            int cmp = isNum ? Integer.compare(d, lastDigit) : 0;
            int w = waviness + (cmp * lastCmp < 0 ? 1 : 0);
            res += dfs(i + 1, w, cmp, d, limitLow && d == lo, limitHigh && d == hi, lowS, highS, memo);
        }

        if (!limitLow && !limitHigh) {
            memo[i][waviness][lastCmp + 1][lastDigit] = res + 1;
        }
        return res;
    }
}
