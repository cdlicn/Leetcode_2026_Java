// TODO 2573. 找出对应 LCP 矩阵的字符串
public class Main_2573 {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        int i = 0; // s[i] 没有填字母
        for (char c = 'a'; c <= 'z'; c++) {
            for (int j = i; j < n; j++) {
                if (lcp[i][j] > 0) { // s[j] == s[i]
                    s[j] = c;
                }
            }
            // 找下一个空位
            while (i < n && s[i] > 0) {
                i++;
            }
            if (i == n) { // 没有空位
                break;
            }
        }

        if (i < n) { // 还有空位
            return "";
        }

        // 验证 s 是否符合 lcp 矩阵
        for (i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 计算后缀 [i,n-1] 和后缀 [j,n-1] 的实际 LCP
                int actualLcp = s[i] != s[j] ? 0 : (i == n - 1 || j == n - 1 ? 1 : lcp[i + 1][j + 1] + 1);
                if (lcp[i][j] != actualLcp) { // 矛盾
                    return "";
                }
            }
        }
        return new String(s);
    }
}
