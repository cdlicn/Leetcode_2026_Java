public class Main_3637 {
    public boolean isTrionic(int[] nums) {
        int idx = 1, n = nums.length;
        while (idx < n && nums[idx] > nums[idx - 1]) idx++;
        if (idx == 1) {
            return false;
        }
        int i0 = idx;
        while (idx < n && nums[idx] < nums[idx - 1]) idx++;
        if (idx == i0 || idx == n) {
            return false;
        }
        while (idx < n && nums[idx] > nums[idx - 1]) idx++;
        return idx == n;
    }
}
