import java.util.Arrays;

public class Main_1877 {
    public int minPairSum(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            res = Math.max(res, nums[i] + nums[n - 1 - i]);
        }
        return res;
    }
}
