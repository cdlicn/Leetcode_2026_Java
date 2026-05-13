public class Main_1674 {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[limit * 2 + 2];
        for (int i = 0; i < n / 2; i++) {
            int x = nums[i], y = nums[n - i - 1];
            int l = Math.min(x, y) + 1, r = Math.max(x, y) + limit;

            diff[2] += 2;
            diff[l] -= 2;

            diff[l]++;
            diff[r + 1]--;

            diff[x + y]--;
            diff[x + y + 1]++;

            diff[r + 1] += 2;
        }
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 2; i <= limit * 2; i++) {
            sum += diff[i];
            res = Math.min(res, sum);
        }
        return res;
    }
}
