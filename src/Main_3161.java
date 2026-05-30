import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

// TODO 3161. 物块放置查询
public class Main_3161 {
    public List<Boolean> getResults(int[][] queries) {
        int m = 0;
        for (int[] q : queries) {
            m = Math.max(m, q[1]);
        }
        m++;

        TreeSet<Integer> set = new TreeSet<>(List.of(0, m)); // 哨兵
        int[] t = new int[2 << (32 - Integer.numberOfLeadingZeros(m))];

        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int x = q[1];
            int pre = set.floor(x - 1); // x 左侧最近障碍物的位置
            if (q[0] == 1) {
                int nxt = set.ceiling(x); // x 右侧最近障碍物的位置
                set.add(x);
                update(t, 1, 0, m, x, x - pre);   // 更新 d[x] = x - pre
                update(t, 1, 0, m, nxt, nxt - x); // 更新 d[nxt] = nxt - x
            } else {
                // 最大长度要么是 [0,pre] 中的最大 d，要么是 [pre,x] 这一段的长度
                int maxGap = Math.max(query(t, 1, 0, m, pre), x - pre);
                ans.add(maxGap >= q[2]);
            }
        }
        return ans;
    }

    // 把 i 处的值改成 val
    private void update(int[] t, int o, int l, int r, int i, int val) {
        if (l == r) {
            t[o] = val;
            return;
        }
        int m = (l + r) / 2;
        if (i <= m) {
            update(t, o * 2, l, m, i, val);
        } else {
            update(t, o * 2 + 1, m + 1, r, i, val);
        }
        t[o] = Math.max(t[o * 2], t[o * 2 + 1]);
    }

    // 查询 [0,R] 中的最大值
    private int query(int[] t, int o, int l, int r, int R) {
        if (r <= R) {
            return t[o];
        }
        int m = (l + r) / 2;
        if (R <= m) {
            return query(t, o * 2, l, m, R);
        }
        return Math.max(t[o * 2], query(t, o * 2 + 1, m + 1, r, R));
    }
}
