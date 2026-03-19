public class Main_3212 {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cntX = new int[m + 1][n + 1], cntY = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cntX[i + 1][j + 1] = cntX[i + 1][j] + cntX[i][j + 1] + (grid[i][j] == 'X' ? 1 : 0) - cntX[i][j];
                cntY[i + 1][j + 1] = cntY[i + 1][j] + cntY[i][j + 1] + (grid[i][j] == 'Y' ? 1 : 0) - cntY[i][j];
                res += (cntX[i + 1][j + 1] != 0 && cntX[i + 1][j + 1] == cntY[i + 1][j + 1]) ? 1 : 0;
            }
        }
        return res;
    }
}
