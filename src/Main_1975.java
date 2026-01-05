public class Main_1975 {
    public long maxMatrixSum(int[][] matrix) {
        long res = 0;
        int minV = Integer.MAX_VALUE, m = matrix.length, n = matrix[0].length, cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.abs(matrix[i][j]);
                minV = Math.min(minV, Math.abs(matrix[i][j]));
                cnt += matrix[i][j] < 0 ? 1 : 0;
            }
        }
        if (cnt % 2 == 1) {
            res -= minV * 2L;
        }
        return res;
    }
}
