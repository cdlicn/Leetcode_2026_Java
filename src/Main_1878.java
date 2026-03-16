import java.util.Arrays;

public class Main_1878 {

    private int x, y, z;

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] preSum1 = new int[m + 1][n + 1], preSum2 = new int[m + 1][n + 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int x = i - 1, y = j - 1;
                preSum1[i][j] = preSum1[x][y] + grid[i - 1][j - 1];
                preSum2[i][j] = preSum2[x][y] + grid[i - 1][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(grid[i][j]);
                int mx = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));
                for (int k = 1; k <= mx; k++) {
                    int a = queryDiagonal(preSum1, i - k, j, k);
                    int b = queryDiagonal(preSum1, i, j - k, k);
                    int c = queryAntiDiagonal(preSum2, i - k + 1, j - 1, k - 1);
                    int d = queryAntiDiagonal(preSum2, i, j + k, k + 1);
                    update(a + b + c + d);
                }
            }
        }

        int[] ans = new int[]{x, y, z};
        int len = 3;
        while (ans[len - 1] == 0) {
            len--;
        }
        return Arrays.copyOf(ans, len);

    }

    private int queryDiagonal(int[][] diagSum, int x, int y, int k) {
        return diagSum[x + k][y + k] - diagSum[x][y];
    }

    private int queryAntiDiagonal(int[][] antiSum, int x, int y, int k) {
        return antiSum[x + k][y + 1 - k] - antiSum[x][y + 1];
    }

    private void update(int v) {
        if (v > x) {
            z = y;
            y = x;
            x = v;
        } else if (v < x && v > y) {
            z = y;
            y = v;
        } else if (v < y && v > z) {
            z = v;
        }
    }

}
