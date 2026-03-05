public class Main_1758 {
    public int minOperations(String s) {
        int cnt0 = 0, cnt1 = 0, x = 0;
        for (char c : s.toCharArray()) {
            int v = c - '0';
            if (x == v) {
                cnt0++;
            } else {
                cnt1++;
            }
            x = 1 - x;
        }
        return Math.min(cnt0, cnt1);
    }
}
