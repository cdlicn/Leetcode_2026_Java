import java.util.*;

public class Main_3650 {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x1 = edge[0];
            int x2 = edge[1];
            int w = edge[2];
            graph[x1].add(new int[]{x2, w});
            graph[x2].add(new int[]{x1, 2 * w});
        }

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1];

            if (d > dist[u]) {
                continue;
            }

            if (u == n - 1) {
                return d;
            }

            // 遍历邻居
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                int newDist = d + w;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{newDist, v});
                }
            }
        }

        return -1;
    }
}
