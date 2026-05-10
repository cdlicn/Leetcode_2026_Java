public class Main_2770 {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] f = new int[n];
        for (int j = 1; j < n; j++) {
            f[j] = Integer.MIN_VALUE;
            for (int i = 0; i < j; i++) {
                if (Math.abs(nums[i] - nums[j]) <= target) { // 可以从 i 跳到 j
                    f[j] = Math.max(f[j], f[i] + 1);
                }
            }
        }
        return f[n - 1] < 0 ? -1 : f[n - 1];
    }
}
