import java.util.HashSet;
import java.util.Set;

public class Main_1980 {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();
        for (String s : nums) {
            set.add(Integer.parseInt(s, 2));
        }
        int res = 0;
        while (set.contains(res)) {
            res++;
        }
        String bin = Integer.toBinaryString(res);
        return "0".repeat(nums.length - bin.length()) + bin;
    }
}
