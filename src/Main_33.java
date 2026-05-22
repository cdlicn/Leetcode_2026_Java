public class Main_33 {
    public int search(int[] nums, int target) {
        int last = nums[nums.length - 1];
        int left = -1;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            int x = nums[mid];
            if (target > last && x <= last) {
                right = mid;
            } else if (x > last && target <= last) {
                left = mid;
            } else if (x >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }
}
