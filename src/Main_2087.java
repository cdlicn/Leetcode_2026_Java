/**
 * @author cdlicn
 * @date 2026年04月04日 22:42
 * @description
 */

public class Main_2087 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int x1 = Math.min(startPos[0], homePos[0]);
        int x2 = Math.max(startPos[0], homePos[0]);
        int y1 = Math.min(startPos[1], homePos[1]);
        int y2 = Math.max(startPos[1], homePos[1]);
        int res = -rowCosts[startPos[0]] - colCosts[startPos[1]];
        while (x1 <= x2) res += rowCosts[x1++];
        while (y1 <= y2) res += colCosts[y1++];
        return res;
    }
}
