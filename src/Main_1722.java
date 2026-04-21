import java.util.*;

class Main_1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, _ -> new ArrayList<>());
        for (int[] e : allowedSwaps) {
            int i = e[0];
            int j = e[1];
            g[i].add(j); // 建图
            g[j].add(i);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int x = 0; x < n; x++) {
            if (!vis[x]) {
                Map<Integer, Integer> diff = new HashMap<>();
                dfs(x, source, target, g, vis, diff);
                for (int c : diff.values()) {
                    ans += Math.abs(c);
                }
            }
        }
        return ans / 2; // 有 ans / 2 对多出来的元素
    }

    private void dfs(int x, int[] source, int[] target, List<Integer>[] g, boolean[] vis, Map<
            Integer, Integer> diff) {
        vis[x] = true; // 避免重复访问
        // 抵消相同的元素，最终剩下 source 和 target 各自多出来的元素（对称差）
        diff.merge(source[x], 1, Integer::sum);  // diff[source[x]]++;
        diff.merge(target[x], -1, Integer::sum); // diff[target[x]]--;
        for (int y : g[x]) {
            if (!vis[y]) {
                dfs(y, source, target, g, vis, diff);
            }
        }
    }
}