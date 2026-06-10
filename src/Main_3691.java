import java.util.PriorityQueue;

// TODO 3691. 最大子数组总值 II
public class Main_3691 {
    class ST {
        private final int[][] stMin;
        private final int[][] stMax;

        public ST(int[] a) {
            int n = a.length;
            int w = 32 - Integer.numberOfLeadingZeros(n);
            stMin = new int[w][n];
            stMax = new int[w][n];

            for (int j = 0; j < n; j++) {
                stMin[0][j] = a[j];
                stMax[0][j] = a[j];
            }

            for (int i = 1; i < w; i++) {
                for (int j = 0; j + (1 << i) <= n; j++) {
                    stMin[i][j] = Math.min(stMin[i - 1][j], stMin[i - 1][j + (1 << (i - 1))]);
                    stMax[i][j] = Math.max(stMax[i - 1][j], stMax[i - 1][j + (1 << (i - 1))]);
                }
            }
        }

        // [l, r) 左闭右开
        public int query(int l, int r) {
            int k = 31 - Integer.numberOfLeadingZeros(r - l);
            int mn = Math.min(stMin[k][l], stMin[k][r - (1 << k)]);
            int mx = Math.max(stMax[k][l], stMax[k][r - (1 << k)]);
            return mx - mn;
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        ST st = new ST(nums);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // 最大堆
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{st.query(i, n), i, n}); // 子数组极差，左端点，右端点加一
        }

        long ans = 0;
        while (k-- > 0 && pq.peek()[0] > 0) {
            int[] top = pq.poll();
            ans += top[0];
            top[2]--;
            top[0] = st.query(top[1], top[2]);
            pq.add(top);
        }
        return ans;
    }
}
