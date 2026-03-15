import java.util.ArrayList;
import java.util.List;

/**
 * @author cdlicn
 * @date 2026年03月15日 22:29
 * @description
 */
// TODO 1622. 奇妙序列
public class Main_1622 {
    class Fancy {
        private static final int MOD = 1_000_000_007;

        private final List<Integer> vals = new ArrayList<>();
        private long add = 0;
        private long mul = 1;

        public void append(int val) {
            // 注意这里有减法，计算结果可能是负数，+MOD 可以保证计算结果非负
            vals.add((int) ((val - add + MOD) * pow(mul, MOD - 2) % MOD));
        }

        public void addAll(int inc) {
            add = (add + inc) % MOD;
        }

        public void multAll(int m) {
            mul = mul * m % MOD;
            add = add * m % MOD;
        }

        public int getIndex(int idx) {
            if (idx >= vals.size()) {
                return -1;
            }
            return (int) ((vals.get(idx) * mul + add) % MOD);
        }

        private long pow(long x, int n) {
            long res = 1;
            for (; n > 0; n /= 2) {
                if (n % 2 > 0) {
                    res = res * x % MOD;
                }
                x = x * x % MOD;
            }
            return res;
        }
    }
}
