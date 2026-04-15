public class Main_2515 {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int d = Math.abs(i - startIndex);
                res = Math.min(res, Math.min(d, n - d));
            }
        }
        return res == n ? -1 : res;
    }
}
