public class Main_1559 {
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 左右上下

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && dfs(i, j, -1, -1, grid, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int px, int py, char[][] grid, boolean[][] vis) {
        vis[x][y] = true;
        for (int[] d : DIRS) { // 枚举移动方向
            int i = x + d[0];
            int j = y + d[1];
            if ((i != px || j != py) && // (i, j) 不是上一步的格子 (px, py)
                    0 <= i && i < grid.length && 0 <= j && j < grid[i].length && // (i, j) 没有出界
                    grid[i][j] == grid[x][y] && // (i, j) 和 (x, y) 的格子值相同
                    (vis[i][j] || dfs(i, j, x, y, grid, vis))) { // 如果之前访问过 (i, j)，那么找到了环，否则继续递归找
                return true;
            }
        }
        return false;
    }
}
