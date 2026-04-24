public class Main_2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int a = 0, b = 0, c = 0;
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'L' -> a++;
                case 'R' -> b++;
                case '_' -> c++;
            }
        }
        return Math.abs(a - b) + c;
    }
}
