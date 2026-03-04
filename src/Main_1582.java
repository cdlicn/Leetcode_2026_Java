public class Main_1582 {
    public int numSpecial(int[][] mat) {
        int res = 0;
        for (int[] row : mat) {
            int rowCnt = 0, idx = -1;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    idx = j;
                    rowCnt++;
                }
            }
            if (rowCnt == 1) {
                int colCnt = 0;
                for (int[] col : mat) {
                    colCnt += col[idx] == 1 ? 1 : 0;
                }
                res += colCnt == 1 ? 1 : 0;
            }
        }
        return res;
    }
}
