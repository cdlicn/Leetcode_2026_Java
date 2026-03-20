import java.util.Arrays;

public class Main_3567 {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m - k + 1][n - k + 1];
        int[] a = new int[k * k];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int idx = 0;
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        a[idx++] = grid[i + x][j + y];
                    }
                }
                Arrays.sort(a);

                int tmp = Integer.MAX_VALUE;
                for (int p = 1; p < a.length; p++) {
                    if (a[p] > a[p - 1]) { // 题目要求相减的两个数必须不同
                        tmp = Math.min(tmp, a[p] - a[p - 1]);
                    }
                }
                if (tmp < Integer.MAX_VALUE) {
                    res[i][j] = tmp;
                }
            }
        }
        return res;
    }
}
