import java.util.HashMap;
import java.util.Map;

public class Main_3740 {
    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> mp = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!mp.containsKey(nums[i])) {
                mp.put(nums[i], new int[]{-1, -1});
            }
            int[] vs = mp.get(nums[i]);
            if (vs[0] == -1) {
                vs[0] = i;
            } else if (vs[1] == -1) {
                vs[1] = i;
            } else {
                res = Math.min(i - vs[1] + i - vs[0] + vs[1] - vs[0], res);
                vs[0] = vs[1];
                vs[1] = i;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
