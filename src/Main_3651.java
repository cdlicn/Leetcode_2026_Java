import java.util.Arrays;

/**
 * @author cdlicn
 * @date 2026年01月28日 23:24
 * @description
 */

// TODO 3651. 带传送的最小路径成本
public class Main_3651 {
    public int minCost(int[][] grid, int k) {
        int n = grid[0].length;
        int mx = 0;
        for (int[] row : grid) {
            for (int x : row) {
                mx = Math.max(mx, x);
            }
        }

        int[] sufMinF = new int[mx + 2];
        Arrays.fill(sufMinF, Integer.MAX_VALUE);
        int[] minF = new int[mx + 1];
        int[] f = new int[n + 1];

        for (int t = 0; t <= k; t++) {
            Arrays.fill(minF, Integer.MAX_VALUE);

            // 64. 最小路径和（空间优化写法）
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            f[1] = -grid[0][0]; // 起点的成本不算
            for (int[] row : grid) {
                for (int j = 0; j < n; j++) {
                    int x = row[j];
                    f[j + 1] = Math.min(Math.min(f[j], f[j + 1]) + x, sufMinF[x]);
                    minF[x] = Math.min(minF[x], f[j + 1]);
                }
            }

            // 计算 minF 的后缀最小值
            for (int i = mx; i >= 0; i--) {
                sufMinF[i] = Math.min(sufMinF[i + 1], minF[i]);
            }
        }

        return f[n];
    }
}
