import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(arr[i], a -> new ArrayList<>()).add(i);
        }

        boolean[] vis = new boolean[n];
        vis[0] = true;
        List<Integer> q = List.of(0);

        for (int res = 0; ; res++) {
            List<Integer> tmp = q;
            q = new ArrayList<>();
            for (int i : tmp) {
                if (i == n - 1) {
                    return res;
                }

                // 往右
                if (!vis[i + 1]) {
                    vis[i + 1] = true;
                    q.add(i + 1);
                }

                // 往左
                if (i > 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.add(i - 1);
                }

                // 访问所有元素值为 arr[i] 的点（下标）
                int x = arr[i];
                List<Integer> idx = pos.get(x);
                if (idx == null) { // 之前访问过
                    continue;
                }
                for (int j : idx) {
                    if (!vis[j]) {
                        vis[j] = true;
                        q.add(j);
                    }
                }
                pos.remove(x); // 避免重复访问
            }
        }
    }
}