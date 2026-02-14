public class Main_799 {
    public double champagneTower(int poured, int queryRow, int queryGlass) {
        double[] cur = new double[]{(double) poured};
        for (int i = 1; i <= queryRow; i++) {
            double[] nxt = new double[i + 1];
            for (int j = 0; j < cur.length; j++) {
                double x = cur[j] - 1;
                if (x > 0) { // 溢出到下一层
                    nxt[j] += x / 2;
                    nxt[j + 1] += x / 2;
                }
            }
            cur = nxt;
        }
        return Math.min(cur[queryGlass], 1);
    }
}
