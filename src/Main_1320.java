import java.util.Arrays;

// TODO 1320. 二指输入的的最小距离
public class Main_1320 {
    private static final int[][] dis = new int[26][26];

    static {
        // 预处理两个字母的距离
        final int COLUMN = 6;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dis[i][j] = Math.abs(i / COLUMN - j / COLUMN) + Math.abs(i % COLUMN - j % COLUMN);
            }
        }
    }

    public int minimumDistance(String word) {
        char[] s = word.toCharArray();
        int n = s.length;

        int[][][] memo = new int[n][26][26];
        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, -1); // -1 表示没有计算过
            }
        }

        int ans = Integer.MAX_VALUE;
        // 最后一定有一根手指在 s[n-1]，另一根手指的位置不确定，枚举
        for (int finger2 = 0; finger2 < 26; finger2++) {
            ans = Math.min(ans, dfs(n - 2, s[n - 1] - 'A', finger2, s, memo));
        }
        return ans;
    }

    private int dfs(int i, int finger1, int finger2, char[] word, int[][][] memo) {
        if (i < 0) {
            return 0;
        }

        if (memo[i][finger1][finger2] != -1) { // 之前计算过
            return memo[i][finger1][finger2];
        }

        // 手指 1 移到 word[i]
        int w = word[i] - 'A';
        int res1 = dfs(i - 1, w, finger2, word, memo) + dis[finger1][w];

        // 手指 2 移到 word[i]
        int res2 = dfs(i - 1, finger1, w, word, memo) + dis[finger2][w];

        int res = Math.min(res1, res2);
        memo[i][finger1][finger2] = res; // 记忆化
        return res;
    }
}
