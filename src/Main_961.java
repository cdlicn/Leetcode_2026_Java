import java.util.HashSet;

public class Main_961 {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (!seen.add(x)) { // x 在 seen 中
                return x;
            }
        }
        return -1; // 代码不会执行到这里
    }
}
