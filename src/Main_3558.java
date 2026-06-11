import java.util.*;

public class Main_3558 {

    private Integer MOD = 1000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            List<Integer> aList = map.getOrDefault(a, new ArrayList<>());
            aList.add(b);
            map.put(a, aList);
            List<Integer> bList = map.getOrDefault(b, new ArrayList<>());
            bList.add(a);
            map.put(b, bList);
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        int n = -2;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.pop();
                List<Integer> list = map.getOrDefault(cur, new ArrayList<>());
                q.addAll(list);
                map.remove(cur);
            }
            n++;
        }
        return (int) pow(2, n - 1);
    }

    private long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }

}
