public class Main_1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int l = start, r = start;
        while (l >= 0 || r < nums.length) {
            if (l >= 0 && nums[l] == target) {
                return start - l;
            }
            if (r < nums.length && nums[r] == target) {
                return r - start;
            }
            l--;
            r++;
        }
        return -1;
    }
}
