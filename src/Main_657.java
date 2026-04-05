/**
 * @author cdlicn
 * @date 2026年04月05日 20:57
 * @description
 */

public class Main_657 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                x++;
            }
            if (c == 'D') {
                x--;
            }
            if (c == 'L') {
                y++;
            }
            if (c == 'R') {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}
