import java.util.ArrayDeque;
import java.util.Deque;

public class Main_1306 {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            Integer idx = q.pop();
            int x = arr[idx];
            if (x == 0) {
                return true;
            }
            int l = idx - x, r = idx + x;
            if (l >= 0 && !visited[l]) {
                q.add(l);
                visited[l] = true;
            }
            if (r < n && !visited[r]) {
                q.add(r);
                visited[r] = true;
            }
        }
        return false;
    }
}
