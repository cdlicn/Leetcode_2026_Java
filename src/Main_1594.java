public class Main_1594 {

    static final int MOD = 1000000007;

    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] minDp = new long[m][n], maxDp = new long[m][n];
        minDp[0][0] = maxDp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            minDp[i][0] = maxDp[i][0] = grid[i][0] * minDp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            minDp[0][j] = maxDp[0][j] = grid[0][j] * minDp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long x1 = Math.min(minDp[i - 1][j], minDp[i][j - 1]) * grid[i][j];
                long x2 = Math.max(maxDp[i - 1][j], maxDp[i][j - 1]) * grid[i][j];
                minDp[i][j] = Math.min(x1, x2);
                maxDp[i][j] = Math.max(x1, x2);
            }
        }
        return maxDp[m - 1][n - 1] < 0 ? -1 : (int) (maxDp[m - 1][n - 1] % MOD);
    }
}
