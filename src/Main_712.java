public class Main_712 {
    public int minimumDeleteSum(String s1, String s2) {
        int sum1 = 0, sum2 = 0;
        int n1 = s1.length(), n2 = s2.length();
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        for (char c : cs1) {
            sum1 += c;
        }
        for (char c : cs2) {
            sum2 += c;
        }
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (cs1[i - 1] == cs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + cs1[i - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return sum1 + sum2 - 2 * dp[n1][n2];
    }
}
