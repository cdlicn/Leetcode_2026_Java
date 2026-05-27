import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cdlicn
 * @date 2026年05月26日 21:59
 * @description
 */

// TODO 3121. 统计特殊字母的数量 II
public class Main_3120 {
    public int numberOfSpecialChars(String word) {
        int ans = 0;
        int[] state = new int[27];
        for (char c : word.toCharArray()) {
            int x = c & 31; // 转成数字 1~26
            if ((c & 32) > 0) { // 小写字母
                if (state[x] == 0) {
                    state[x] = 1;
                } else if (state[x] == 2) { // 大写的后面不能有小写
                    state[x] = -1;
                    ans--;
                }
            } else { // 大写字母
                if (state[x] == 0) { // 还没遇到小写，就先遇到大写了
                    state[x] = -1;
                } else if (state[x] == 1) {
                    state[x] = 2;
                    ans++;
                }
            }
        }
        return ans;
    }
}
