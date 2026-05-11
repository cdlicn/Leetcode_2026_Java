import java.util.ArrayList;
import java.util.List;

public class Main_2553 {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            while (num != 0) {
                list.add(num % 10);
                num /= 10;
            }
        }

        int[] res = new int[list.size()];
        int n = list.size();
        for (int i = 0; i < n; i++) {
            res[i] = list.get(n - i - 1);
        }
        return res;
    }
}
