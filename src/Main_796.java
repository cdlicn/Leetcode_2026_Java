/**
 * @author cdlicn
 * @date 2026年05月03日 22:22
 * @description
 */

public class Main_796 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
