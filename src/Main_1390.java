public class Main_1390 {

    private static int MX = 1_000_01;
    private static int[] fre = new int[MX];
    private static int[] sum = new int[MX];

    static {
        for (int i = 1; i < MX; i++) {
            for (int j = i; j < MX; j += i) {
                fre[j]++;
                sum[j] += i;
            }
        }
    }

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (fre[num] == 4) {
                res += sum[num];
            }
        }
        return res;
    }
}
