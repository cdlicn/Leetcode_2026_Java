import java.util.HashMap;
import java.util.Map;

public class Main_3761 {

    private int reverse(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                res = Math.min(res, i - mp.get(nums[i]));
            }
            mp.put(reverse(nums[i]), i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
