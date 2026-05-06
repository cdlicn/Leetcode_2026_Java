public class Main_1861 {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            char[] row = boxGrid[i];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                char ch = row[j];
                if (ch == '#') {
                    cnt++;
                    ch = '.';
                }
                res[j][m - 1 - i] = ch;
                if (j == n - 1 || row[j + 1] == '*') {
                    for (int k = j; k > j - cnt; k--) {
                        res[k][m - 1 - i] = '#';
                    }
                    cnt = 0;
                }
            }
        }
        return res;
    }
}
