public class Main_2784 {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] cnt = new int[n + 1];
        for (int x : nums) {
            if (x > n) {
                return false;
            }
            cnt[x]++;
            if (x != n && cnt[x] > 1) {
                return false;
            }
            if (x == n && cnt[x] > 2) {
                return false;
            }
        }
        return true;
    }
}
