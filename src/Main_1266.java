public class Main_1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            int[] p = points[i - 1];
            int[] q = points[i];
            ans += Math.max(Math.abs(p[0] - q[0]), Math.abs(p[1] - q[1]));
        }
        return ans;
    }
}
