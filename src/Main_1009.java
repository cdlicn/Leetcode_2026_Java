public class Main_1009 {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int w = 32 - Integer.numberOfLeadingZeros(n);
        return ((1 << w) - 1) ^ n;
    }
}
