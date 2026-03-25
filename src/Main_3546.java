
public class Main_3546 {
    public boolean canPartitionGrid(int[][] grid) {
        // 水平分割
        int m = grid.length - 1, i = 0;
        long cnt = 0;
        while (i <= m) {
            if (cnt <= 0) {
                for (int val : grid[i]) {
                    cnt += val;
                }
                i++;
            } else {
                for (int val : grid[m]) {
                    cnt -= val;
                }
                m--;
            }
        }
        if (cnt == 0) {
            return true;
        }

        // 垂直分割
        int n = grid[0].length - 1, j = 0;
        cnt = 0;
        while (j <= n) {
            if (cnt <= 0) {
                for (int[] val : grid) {
                    cnt += val[j];
                }
                j++;
            } else {
                for (int[] val : grid) {
                    cnt -= val[n];
                }
                n--;
            }
        }
        return cnt == 0;
    }
}
