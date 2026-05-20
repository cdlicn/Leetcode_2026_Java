import java.util.HashMap;
import java.util.Map;

public class Main_2657 {
    // 1 3 2 4
    // 3 1 2 4
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer, Integer> mpA = new HashMap<>(), mpB = new HashMap<>();
        int n = A.length;
        int[] res = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = A[i], y = B[i];
            mpA.put(x, mpA.getOrDefault(x, 0) + 1);
            mpB.put(y, mpB.getOrDefault(y, 0) + 1);

            int aa = mpA.getOrDefault(x, 0), ab = mpB.getOrDefault(x, 0);
            int add = Math.min(aa, ab);
            cnt += add;
            mpA.put(x, aa - add);
            mpB.put(x, ab - add);

            int bb = mpA.getOrDefault(y, 0), ba = mpB.getOrDefault(y, 0);
            add = Math.min(bb, ba);
            cnt += add;
            mpA.put(y, bb - add);
            mpB.put(y, ba - add);

            res[i] = cnt;
        }
        return res;
    }
}
