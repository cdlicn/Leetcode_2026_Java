public class Main_3713 {
    public int longestBalanced(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            next:
            for (int j = i; j < n; j++) {
                int base = ++cnt[s[j] - 'a'];
                for (int c : cnt) {
                    if (c > 0 && c != base) {
                        continue next;
                    }
                }
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
