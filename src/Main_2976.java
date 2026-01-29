import java.lang.reflect.Array;
import java.util.Arrays;

public class Main_2976 {

    private static final int INF = Integer.MAX_VALUE / 2;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] graph = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        int n = original.length;
        for (int i = 0; i < n; i++) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            graph[x][y] = Math.min(graph[x][y], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (graph[i][k] == INF) {
                    continue;
                }
                for (int j = 0; j < 26; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        int m = source.length();
        long res = 0;
        for (int i = 0; i < m; i++) {
            long z = graph[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if (z == INF) {
                return -1;
            }
            res += z;
        }
        return res;
    }
}
