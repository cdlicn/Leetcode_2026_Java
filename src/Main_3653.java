public class Main_3653 {

    public static int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            int l = query[0], r = query[1], k = query[2], v = query[3];
            for (int i = l; i <= r; i += k) {
                nums[i] = (int) (((long) v * nums[i]) % MOD);
            }
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = (res ^ nums[i]);
        }
        return res;
    }
}
