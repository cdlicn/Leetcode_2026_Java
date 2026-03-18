public class Main_3070 {
    public int countSubmatrices(int[][] grid, int k) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        int[][] rowSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rowSum[i + 1][j + 1] = rowSum[i][j + 1] + rowSum[i + 1][j] - rowSum[i][j] + grid[i][j]) <= k) {
                    res++;
                }
            }
        }
        return res;
    }
}