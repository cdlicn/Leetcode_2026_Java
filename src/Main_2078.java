public class Main_2078 {
    public int maxDistance(int[] colors) {
        int c = colors[0], n = colors.length;
        int l = 1;
        while (colors[l] == c) {
            l++;
        }
        int r = n - 1;
        while (colors[r] == c) {
            r--;
        }
        return Math.max(n - 1 - l, r);
    }
}
