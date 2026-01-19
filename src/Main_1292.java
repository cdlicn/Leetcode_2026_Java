import java.util.Arrays;

public class Main_1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = res + 1; k <= Math.min(i, j); k++) {
                    int i1 = i - k + 1;
                    int j1 = j - k + 1;
                    int sum = preSum[i][j] - preSum[i1 - 1][j] - preSum[i][j1 - 1] + preSum[i1 - 1][j1 - 1];
                    if (sum <= threshold) {
                        res = k;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
