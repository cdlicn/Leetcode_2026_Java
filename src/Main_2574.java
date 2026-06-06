public class Main_2574 {
    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int lef = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            nums[i] = Math.abs(2 * lef + x - total);
            lef += x;
        }
        return nums;
    }
}
