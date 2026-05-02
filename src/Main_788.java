/**
 * @author cdlicn
 * @date 2026年05月02日 22:53
 * @description
 */

public class Main_788 {

    public boolean f(int v) {
        boolean flag = false;
        while (v != 0) {
            int x = v % 10;
            if (x == 3 || x == 4 || x == 7) {
                return false;
            }
            if (x != 0 && x != 1 && x != 8) {
                flag = true;
            }
            v /= 10;
        }
        return flag;
    }

    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += f(i) ? 1 : 0;
        }
        return res;
    }
}
