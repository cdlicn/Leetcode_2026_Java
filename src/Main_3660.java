public class Main_3660 {
    // 右边小的，左边大的
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] preMax = new int[n];
        preMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        int[] res = new int[n];
        int sufMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = preMax[i] <= sufMin ? preMax[i] : res[i + 1];
            sufMin = Math.min(sufMin, nums[i]);
        }
        return res;
    }
}
