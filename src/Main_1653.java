public class Main_1653 {
    public int minimumDeletions(String s) {
        int f = 0;
        int cntB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                cntB++; // f 值不变
            } else {
                f = Math.min(f + 1, cntB);
            }
        }
        return f;
    }
}
