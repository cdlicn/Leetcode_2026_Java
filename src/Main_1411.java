import java.util.HashMap;
import java.util.Map;

// TODO 1411. 给 N x 3 网格图涂色的方案数
public class Main_1411 {
    private static final int MOD = 1_000_000_007;

    private static Map<Integer, Integer> memo = new HashMap<>();

    public int numOfWays(int n) {
        return dfs(n, 0, 0, 0);
    }

    private int dfs(int i, int j, int preRow, int curRow) {
        if (i == 0) {
            return 1;
        }

        if (j == 3) {
            return dfs(i - 1, 0, curRow, 0);
        }

        int ket = (i << 14) | (j << 12) | (preRow << 6) | curRow;
        if (memo.containsKey(ket)) {
            return memo.get(ket);
        }

        int res = 0;
        for (int col = 0; col < 3; col++) {
            if (preRow > 0 && col == (preRow >> (j * 2) & 3) ||
                    j > 0 && col == (curRow >> ((j - 1) * 2) & 3)) {
                continue;
            }
            res = (res + dfs(i, j + 1, preRow, curRow | (col << (j * 2)))) % MOD;
        }

        memo.put(ket, res);
        return res;
    }

}
