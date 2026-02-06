import java.util.Arrays;

public class Main_3634 {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int maxSave = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            while ((long) nums[left] * k < nums[i]) {
                left++;
            }
            maxSave = Math.max(maxSave, i - left + 1);
        }
        return nums.length - maxSave;
    }
}
