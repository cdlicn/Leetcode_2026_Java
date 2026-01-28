import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i] - arr[i - 1];
            if (x < min) {
                min = x;
                res.clear();
            }
            if (min == x) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return res;
    }
}
