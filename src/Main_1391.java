import java.util.Arrays;

public class Main_1391 {

    int m, n;
    int[][] grid;
    int[][][] dist = new int[][][]{
            {},
            {
                    {0, -1},
                    {0, 1}
            },
            {
                    {-1, 0},
                    {1, 0}
            },
            {
                    {0, -1},
                    {1, 0},
            },
            {
                    {0, 1},
                    {1, 0}
            },
            {
                    {-1, 0},
                    {0, -1}
            },
            {
                    {-1, 0},
                    {0, 1}
            },
    };

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        boolean[][] vis = new boolean[m][n];
        return dfs(0, 0, vis);
    }

    private boolean dfs(int x, int y, boolean[][] vis) {
        int m = grid.length;
        int n = grid[x].length;
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        vis[x][y] = true;
        for (int[] d : dist[grid[x][y]]) {
            int i = x + d[0];
            int j = y + d[1];
            if (0 <= i && i < m && 0 <= j && j < n && !vis[i][j] &&
                    contains(grid[i][j], -d[0], -d[1]) && dfs(i, j, vis)) {
                return true;
            }
        }
        return false;
    }

    private boolean contains(int street, int dx, int dy) {
        int[][] ds = dist[street];
        return ds[0][0] == dx && ds[0][1] == dy ||
                ds[1][0] == dx && ds[1][1] == dy;
    }

}
