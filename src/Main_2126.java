import java.util.Arrays;

public class Main_2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int idx = 0;
        long n = mass;
        while (idx < asteroids.length && n >= asteroids[idx]) {
            n += asteroids[idx++];
        }
        return idx == asteroids.length;
    }
}
