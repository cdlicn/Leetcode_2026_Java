import java.util.Arrays;

public class Main_1665 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int ans = 0;
        int s = 0;
        for (int[] t : tasks) {
            int actual = t[0];
            int minimum = t[1];
            ans = Math.max(ans, s + minimum);
            s += actual;
        }
        return ans;
    }
}
