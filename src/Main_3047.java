/**
 * @author cdlicn
 * @date 2026年01月17日 8:30
 * @description
 */

public class Main_3047 {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int maxSide = 0;
        for (int i = 0; i < bottomLeft.length; i++) {
            int[] b1 = bottomLeft[i];
            int[] t1 = topRight[i];
            for (int j = 0; j < i; j++) {
                int[] b2 = bottomLeft[j];
                int[] t2 = topRight[j];
                int width = Math.min(t1[0], t2[0]) - Math.max(b1[0], b2[0]);
                int height = Math.min(t1[1], t2[1]) - Math.max(b1[1], b2[1]);
                int side = Math.min(width, height);
                maxSide = Math.max(maxSide, side);
            }
        }
        return (long) maxSide * maxSide;
    }
}
