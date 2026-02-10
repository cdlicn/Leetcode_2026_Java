import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cdlicn
 * @date 2026年02月10日 15:04
 * @description
 */

public class Main_3719 {
    class LazySegmentTree {
        private static final class Node {
            int min;
            int max;
            int todo;
        }

        // 把懒标记作用到 node 子树
        private void apply(int node, int todo) {
            Node cur = tree[node];
            cur.min += todo;
            cur.max += todo;
            cur.todo += todo;
        }

        private final int n;
        private final Node[] tree;

        // 线段树维护一个长为 n 的数组（下标从 0 到 n-1）
        public LazySegmentTree(int n) {
            this.n = n;
            tree = new Node[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
            Arrays.setAll(tree, _ -> new Node());
        }

        // 用 f 更新 [ql, qr] 中的每个 sum[i]
        // 0 <= ql <= qr <= n-1
        // 时间复杂度 O(log n)
        public void update(int ql, int qr, int f) {
            update(1, 0, n - 1, ql, qr, f);
        }

        // 查询 [ql, qr] 内第一个等于 target 的元素下标
        // 找不到返回 -1
        // 0 <= ql <= qr <= n-1
        // 时间复杂度 O(log n)
        public int findFirst(int ql, int qr, int target) {
            return findFirst(1, 0, n - 1, ql, qr, target);
        }

        // 把当前节点的懒标记下传给左右儿子
        private void spread(int node) {
            int todo = tree[node].todo;
            if (todo == 0) { // 没有需要下传的信息
                return;
            }
            apply(node * 2, todo);
            apply(node * 2 + 1, todo);
            tree[node].todo = 0; // 下传完毕
        }

        // 合并左右儿子的 val 到当前节点的 val
        private void maintain(int node) {
            tree[node].min = Math.min(tree[node * 2].min, tree[node * 2 + 1].min);
            tree[node].max = Math.max(tree[node * 2].max, tree[node * 2 + 1].max);
        }

        private void update(int node, int l, int r, int ql, int qr, int f) {
            if (ql <= l && r <= qr) { // 当前子树完全在 [ql, qr] 内
                apply(node, f);
                return;
            }
            spread(node);
            int m = (l + r) / 2;
            if (ql <= m) { // 更新左子树
                update(node * 2, l, m, ql, qr, f);
            }
            if (qr > m) { // 更新右子树
                update(node * 2 + 1, m + 1, r, ql, qr, f);
            }
            maintain(node);
        }

        private int findFirst(int node, int l, int r, int ql, int qr, int target) {
            if (l > qr || r < ql || target < tree[node].min || target > tree[node].max) {
                return -1;
            }
            if (l == r) {
                return l;
            }
            spread(node);
            int m = (l + r) / 2;
            int idx = findFirst(node * 2, l, m, ql, qr, target);
            if (idx < 0) {
                idx = findFirst(node * 2 + 1, m + 1, r, ql, qr, target);
            }
            return idx;
        }
    }

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        LazySegmentTree t = new LazySegmentTree(n + 1);

        Map<Integer, Integer> last = new HashMap<>(); // nums 的元素上一次出现的位置
        int ans = 0;
        int curSum = 0;

        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            int v = x % 2 > 0 ? 1 : -1;
            Integer j = last.get(x);
            if (j == null) { // 首次遇到 x
                curSum += v;
                t.update(i, n, v); // sum 的 [i,n] 增加 v
            } else { // 再次遇到 x
                t.update(j, i - 1, -v); // 撤销之前对 sum 的 [j,i-1] 的增加
            }
            last.put(x, i);

            // 把 i-1 优化成 i-1-ans，因为在下标 > i-1-ans 中搜索是没有意义的，不会把答案变大
            int l = t.findFirst(0, i - 1 - ans, curSum);
            if (l >= 0) {
                ans = i - l; // 如果找到了，那么答案肯定会变大
            }
        }
        return ans;
    }
}
