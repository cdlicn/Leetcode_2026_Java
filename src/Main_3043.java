import java.util.HashSet;
import java.util.Set;

/**
 * @author cdlicn
 * @date 2026年05月21日 20:19
 * @description
 */

public class Main_3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int res = 0;
        Set<String> st = new HashSet<>();
        for (int i : arr1) {
            String str = String.valueOf(i);
            String prefix = "";
            for (char c : str.toCharArray()) {
                prefix += c;
                st.add(prefix);
            }
        }
        for (int val : arr2) {
            String str = String.valueOf(val);
            String prefix = "";
            int len = 0;
            for (char c : str.toCharArray()) {
                prefix += c;
                if (!st.contains(prefix)) {
                    break;
                }
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
