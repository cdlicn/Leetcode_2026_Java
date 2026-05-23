public class Main_1752 {
    public boolean check(int[] nums) {
        int mn = nums[0], n = nums.length;
        int i = 1;
        for (; i < n && nums[i - 1] <= nums[i]; i++) ;
        if (i < n && nums[i] > mn) {
            return false;
        }
        i++;
        for (; i < n && nums[i - 1] <= nums[i] && nums[i] <= mn; i++) ;
        return i >= n;
    }
}
