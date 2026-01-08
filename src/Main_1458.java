public class Main_1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int mx1 = dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1];
                int mx2 = Math.max(dp[i][j - 1], dp[i - 1][j]);
                int mx3 = Math.max(dp[i - 1][j - 1], nums1[i - 1] * nums2[j - 1]);
                dp[i][j] = Math.max(mx1, Math.max(mx2, mx3));
            }
        }
        return dp[m][n];
    }
}
