import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cdlicn
 * @date 2026年05月26日 21:59
 * @description
 */

public class Main_3120 {
    public int numberOfSpecialChars(String word) {
        int[] mask = new int[2];
        for (char c : word.toCharArray()) {
            mask[c >> 5 & 1] |= 1 << (c & 31);
        }
        return Integer.bitCount(mask[0] & mask[1]);
    }
}
