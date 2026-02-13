import java.util.HashMap;
import java.util.Map;

// TODO 3714. 最长的平衡子串 II
public class Main_3714 {
    public int longestBalanced(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;

        // 一种字母
        for (int i = 0; i < n; ) {
            int start = i;
            for (i++; i < n && s[i] == s[i - 1]; i++) ;
            ans = Math.max(ans, i - start);
        }

        // 两种字母
        ans = Math.max(ans, f(s, 'a', 'b'));
        ans = Math.max(ans, f(s, 'a', 'c'));
        ans = Math.max(ans, f(s, 'b', 'c'));

        // 三种字母
        // 把 (x, y) 压缩成一个 long，方便保存至哈希表
        // (x, y) 变成 (x + n) << 20 | (y + n)，其中 +n 避免出现负数
        Map<Long, Integer> pos = new HashMap<>();
        pos.put((long) n << 20 | n, -1); // 前缀和数组的首项是 0，位置相当于在 -1
        int[] cnt = new int[3];
        for (int i = 0; i < n; i++) {
            cnt[s[i] - 'a']++;
            long p = (long) (cnt[0] - cnt[1] + n) << 20 | (cnt[1] - cnt[2] + n);
            if (pos.containsKey(p)) {
                ans = Math.max(ans, i - pos.get(p));
            } else {
                pos.put(p, i);
            }
        }
        return ans;
    }

    private int f(char[] s, char x, char y) {
        int n = s.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> pos = new HashMap<>();
            pos.put(0, i - 1); // 前缀和数组的首项是 0，位置相当于在 i-1
            int d = 0; // x 的个数减去 y 的个数
            for (; i < n && (s[i] == x || s[i] == y); i++) {
                d += s[i] == x ? 1 : -1;
                if (pos.containsKey(d)) {
                    ans = Math.max(ans, i - pos.get(d));
                } else {
                    pos.put(d, i);
                }
            }
        }
        return ans;
    }
}
