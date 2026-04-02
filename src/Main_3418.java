import java.util.Arrays;

public class Main_3418 {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] memo = new int[m][n][3];
        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        return dfs(m - 1, n - 1, 2, coins, memo);
    }

    private int dfs(int i, int j, int k, int[][] coins, int[][][] memo) {
        if (i < 0 || j < 0) {
            return Integer.MIN_VALUE;
        }
        int x = coins[i][j];
        if (i == 0 && j == 0) {
            return k > 0 ? Math.max(x, 0) : x;
        }
        if (memo[i][j][k] != Integer.MIN_VALUE) { // 之前计算过
            return memo[i][j][k];
        }
        int res = Math.max(dfs(i - 1, j, k, coins, memo), dfs(i, j - 1, k, coins, memo)) + x; // 选
        if (k > 0 && x < 0) {
            res = Math.max(res, Math.max(dfs(i - 1, j, k - 1, coins, memo), dfs(i, j - 1, k - 1, coins, memo))); // 不选
        }
        return memo[i][j][k] = res; // 记忆化
    }
}
