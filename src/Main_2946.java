public class Main_2946 {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        for (int[] ints : mat) {
            for (int j = 0; j < n; j++) {
                int x = (j + k) % n;
                if (ints[j] != ints[x]) {
                    return false;
                }
            }
        }
        return true;
    }
}
