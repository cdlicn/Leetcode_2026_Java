import java.util.Arrays;

public class Main_2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        for (int i = cost.length - 1; i >= 0; i -= 2) {
            if (i == 0) {
                res += cost[i];
            } else {
                res += cost[i] + cost[i - 1];
            }
        }
        return res;
    }
}
