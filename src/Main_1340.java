public class Main_1340 {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] memo = new int[n];

        // 枚举起点
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d, memo));
        }
        return ans;
    }

    private int dfs(int i, int[] arr, int d, int[] memo) {
        if (memo[i] > 0) { // 之前计算过
            return memo[i];
        }

        int res = 1;

        // 往左跳
        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[j] < arr[i]; j--) {
            res = Math.max(res, dfs(j, arr, d, memo) + 1);
        }

        // 往右跳
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1) && arr[j] < arr[i]; j++) {
            res = Math.max(res, dfs(j, arr, d, memo) + 1);
        }

        memo[i] = res; // 记忆化
        return res;
    }
}
