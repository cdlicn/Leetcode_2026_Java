public class Main_1895 {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rowSum = new int[m][n + 1];      // → 前缀和
        int[][] colSum = new int[m + 1][n];      // ↓ 前缀和
        int[][] diagSum = new int[m + 1][n + 1]; // ↘ 前缀和
        int[][] antiSum = new int[m + 1][n + 1]; // ↙ 前缀和

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];
                rowSum[i][j + 1] = rowSum[i][j] + x;
                colSum[i + 1][j] = colSum[i][j] + x;
                diagSum[i + 1][j + 1] = diagSum[i][j] + x;
                antiSum[i + 1][j] = antiSum[i][j + 1] + x;
            }
        }

        // isSameColSum[i][j] 表示右下角为 (i, j) 的子矩形，每列元素和是否都相等
        boolean[][] isSameColSum = new boolean[m][n];

        for (int k = Math.min(m, n); k > 1; k--) {
            for (int i = k; i <= m; i++) {
                // 想象有一个 k×k 的窗口在向右滑动
                int sameCnt = 1;
                for (int j = 1; j < n; j++) {
                    if (colSum[i][j] - colSum[i - k][j] == colSum[i][j - 1] - colSum[i - k][j - 1]) {
                        sameCnt++;
                    } else {
                        sameCnt = 1;
                    }
                    // 连续 k 列元素和是否都一样
                    isSameColSum[i - 1][j] = sameCnt >= k;
                }
            }

            for (int j = k; j <= n; j++) {
                // 想象有一个 k×k 的窗口在向下滑动
                int sum = rowSum[0][j] - rowSum[0][j - k];
                int sameCnt = 1;
                for (int i = 2; i <= m; i++) {
                    int rowS = rowSum[i - 1][j] - rowSum[i - 1][j - k];
                    if (rowS == sum) {
                        sameCnt++;
                        if (sameCnt >= k && // 连续 k 行元素和都一样
                                isSameColSum[i - 1][j - 1] && // 连续 k 列元素和都一样
                                colSum[i][j - 1] - colSum[i - k][j - 1] == sum && // 列和 = 行和
                                diagSum[i][j] - diagSum[i - k][j - k] == sum && // 主对角线和 = 行和
                                antiSum[i][j - k] - antiSum[i - k][j] == sum) { // 反对角线和 = 行和
                            return k;
                        }
                    } else {
                        sum = rowS;
                        sameCnt = 1;
                    }
                }
            }
        }

        return 1;
    }
}
