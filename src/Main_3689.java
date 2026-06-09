public class Main_3689 {
    public long maxTotalValue(int[] nums, int k) {
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (int num : nums) {
            mx = Math.max(mx, num);
            mn = Math.min(mn, num);
        }
        return (long) (mx - mn) * k;
    }
}
