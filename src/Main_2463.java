import java.util.Arrays;
import java.util.List;

public class Main_2463 {
    public long minimumTotalDistance(List<Integer> robotList, int[][] factory) {
        int[] robot = robotList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = factory.length;
        int m = robot.length;
        long[][] memo = new long[n][m];
        for (long[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }

        return dfs(n - 1, m - 1, robot, factory, memo);
    }

    private long dfs(int i, int j, int[] robot, int[][] factory, long[][] memo) {
        if (j < 0) { // 所有机器人都修完了
            return 0;
        }
        if (i < 0) { // 还有机器人没修，但没有工厂了
            return Long.MAX_VALUE / 2; // 避免加法溢出
        }

        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }

        // 工厂 i 不修机器人
        long res = dfs(i - 1, j, robot, factory, memo);

        int position = factory[i][0];
        int limit = factory[i][1];
        long disSum = 0;
        // 枚举修 k 个机器人
        for (int k = 1; k <= Math.min(j + 1, limit); k++) {
            disSum += Math.abs(robot[j - k + 1] - position);
            res = Math.min(res, dfs(i - 1, j - k, robot, factory, memo) + disSum);
        }

        memo[i][j] = res; // 记忆化
        return res;
    }
}
