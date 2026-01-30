import java.util.Arrays;

// TODO 2977. 转换字符串的最小成本 II
public class Main_2977 {
    class Node {
        Node[] son = new Node[26];
        int sid = -1; // 字符串的编号
    }

    private Node root = new Node();
    private int sid = 0;
    private char[] s, t;
    private int[][] dis;
    private long[] memo;

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        // 初始化距离矩阵
        int m = cost.length;
        dis = new int[m * 2][m * 2];
        for (int i = 0; i < dis.length; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
            dis[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int x = put(original[i]);
            int y = put(changed[i]);
            dis[x][y] = Math.min(dis[x][y], cost[i]);
        }

        // Floyd 求任意两点最短路
        for (int k = 0; k < sid; k++) {
            for (int i = 0; i < sid; i++) {
                if (dis[i][k] == Integer.MAX_VALUE / 2) {
                    continue;
                }
                for (int j = 0; j < sid; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        s = source.toCharArray();
        t = target.toCharArray();
        memo = new long[s.length];
        Arrays.fill(memo, -1);
        long ans = dfs(0);
        return ans < Long.MAX_VALUE / 2 ? ans : -1;
    }

    private int put(String s) {
        Node o = root;
        for (char b : s.toCharArray()) {
            int i = b - 'a';
            if (o.son[i] == null) {
                o.son[i] = new Node();
            }
            o = o.son[i];
        }
        if (o.sid < 0) {
            o.sid = sid++;
        }
        return o.sid;
    }

    private long dfs(int i) {
        if (i >= s.length) {
            return 0;
        }
        if (memo[i] != -1) { // 之前算过
            return memo[i];
        }
        long res = Long.MAX_VALUE / 2;
        if (s[i] == t[i]) {
            res = dfs(i + 1); // 不修改 source[i]
        }
        Node p = root, q = root;
        for (int j = i; j < s.length; j++) {
            p = p.son[s[j] - 'a'];
            q = q.son[t[j] - 'a'];
            if (p == null || q == null) {
                break;
            }
            if (p.sid < 0 || q.sid < 0) {
                continue;
            }
            // 修改从 i 到 j 的这一段
            int d = dis[p.sid][q.sid];
            if (d < Integer.MAX_VALUE / 2) {
                res = Math.min(res, d + dfs(j + 1));
            }
        }
        return memo[i] = res; // 记忆化
    }
}
