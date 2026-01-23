import java.util.TreeSet;

/**
 * @author cdlicn
 * @date 2026年01月23日 23:10
 * @description
 */

public class Main_3510 {
    private record Pair(long s, int i) {
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        // (相邻元素和，左边那个数的下标)
        TreeSet<Pair> pairs = new TreeSet<>((a, b) -> a.s != b.s ? Long.compare(a.s, b.s) : a.i - b.i);
        int dec = 0; // 递减的相邻对的个数
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i];
            int y = nums[i + 1];
            if (x > y) {
                dec++;
            }
            pairs.add(new Pair(x + y, i));
        }

        // 剩余下标
        TreeSet<Integer> idx = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            idx.add(i);
        }

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
        }

        int ans = 0;
        while (dec > 0) {
            ans++;

            // 删除相邻元素和最小的一对
            Pair p = pairs.pollFirst();
            long s = p.s;
            int i = p.i;

            // (当前元素，下一个数)
            int nxt = idx.higher(i);
            if (a[i] > a[nxt]) { // 旧数据
                dec--;
            }

            // (前一个数，当前元素)
            Integer pre = idx.lower(i);
            if (pre != null) {
                if (a[pre] > a[i]) { // 旧数据
                    dec--;
                }
                if (a[pre] > s) { // 新数据
                    dec++;
                }
                pairs.remove(new Pair(a[pre] + a[i], pre));
                pairs.add(new Pair(a[pre] + s, pre));
            }

            // (下一个数，下下一个数)
            Integer nxt2 = idx.higher(nxt);
            if (nxt2 != null) {
                if (a[nxt] > a[nxt2]) { // 旧数据
                    dec--;
                }
                if (s > a[nxt2]) { // 新数据（当前元素，下下一个数）
                    dec++;
                }
                pairs.remove(new Pair(a[nxt] + a[nxt2], nxt));
                pairs.add(new Pair(s + a[nxt2], i));
            }

            a[i] = s; // 把 a[nxt] 加到 a[i] 中
            idx.remove(nxt); // 删除 nxt
        }
        return ans;
    }
}
