public class Main_66 {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i] = digits[i] + 1;
        int plus = digits[i] / 10;
        digits[i] %= 10;
        i--;
        while (i >= 0 && plus == 1) {
            digits[i] += 1;
            plus = digits[i] / 10;
            digits[i] %= 10;
            i--;
        }
        if (plus == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
