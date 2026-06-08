import java.util.ArrayList;
import java.util.List;

public class Main_2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        for (int x : nums) {
            if (x < pivot) {
                a.add(x);
            } else if (x == pivot) {
                b.add(x);
            } else {
                c.add(x);
            }
        }

        int[] ans = new int[nums.length];
        int idx = 0;
        for (int x : a) ans[idx++] = x;
        for (int x : b) ans[idx++] = x;
        for (int x : c) ans[idx++] = x;
        return ans;
    }
}
