import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cdlicn
 * @date 2026年03月13日 22:29
 * @description
 */

public class Main_3296 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return o1[0] - o2[0] > 0 ? 1 : -1;
            }
        });
        for (int a : workerTimes) {
            pq.add(new long[]{a, a, a});
        }
        long res = 0;
        while (mountainHeight-- > 0) {
            long[] poll = pq.poll();
            long total = poll[0], cur = poll[1], add = poll[2];
            res = total;
            pq.add(new long[]{total + cur + add, cur + add, add});
        }
        return res;
    }
}
