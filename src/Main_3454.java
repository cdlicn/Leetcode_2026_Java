import java.util.Arrays;

// TODO 3454. 分割正方形 II
public class Main_3454 {
    class SegmentTree {
        private final int n;
        private final int[] minCoverLen; // 区间内被矩形覆盖次数最少的底边长之和
        private final int[] minCover;    // 区间内被矩形覆盖的最小次数
        private final int[] todo;        // 子树内的所有节点的 minCover 需要增加的量，注意这可以是负数

        public SegmentTree(int[] xs) {
            n = xs.length - 1; // xs.length 个横坐标有 xs.length-1 个差值
            int size = 2 << (32 - Integer.numberOfLeadingZeros(n - 1));
            minCoverLen = new int[size];
            minCover = new int[size];
            todo = new int[size];
            build(xs, 1, 0, n - 1);
        }

        public void update(int l, int r, int v) {
            update(1, 0, n - 1, l, r, v);
        }

        public int getUncoveredLength() {
            return minCover[1] == 0 ? minCoverLen[1] : 0;
        }

        // 根据左右儿子的信息，更新当前节点的信息
        private void maintain(int o) {
            int mn = Math.min(minCover[o * 2], minCover[o * 2 + 1]);
            minCover[o] = mn;
            // 只统计等于 mn 的底边长之和
            minCoverLen[o] = (minCover[o * 2] == mn ? minCoverLen[o * 2] : 0) +
                    (minCover[o * 2 + 1] == mn ? minCoverLen[o * 2 + 1] : 0);
        }

        // 仅更新节点信息，不下传懒标记 todo
        private void do_(int o, int v) {
            minCover[o] += v;
            todo[o] += v;
        }

        // 下传懒标记 todo
        private void spread(int o) {
            if (todo[o] != 0) {
                do_(o * 2, todo[o]);
                do_(o * 2 + 1, todo[o]);
                todo[o] = 0;
            }
        }

        // 建树
        private void build(int[] xs, int o, int l, int r) {
            if (l == r) {
                minCoverLen[o] = xs[l + 1] - xs[l];
                return;
            }
            int m = (l + r) / 2;
            build(xs, o * 2, l, m);
            build(xs, o * 2 + 1, m + 1, r);
            maintain(o);
        }

        // 区间更新
        private void update(int o, int l, int r, int ql, int qr, int v) {
            if (ql <= l && r <= qr) {
                do_(o, v);
                return;
            }
            spread(o);
            int m = (l + r) / 2;
            if (ql <= m) {
                update(o * 2, l, m, ql, qr, v);
            }
            if (m < qr) {
                update(o * 2 + 1, m + 1, r, ql, qr, v);
            }
            maintain(o);
        }
    }

    private record Event(int y, int lx, int rx, int delta) {
    }

    private record Record(long area, int sumLen) {
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length * 2;
        int[] xs = new int[n];
        Event[] events = new Event[n];
        n = 0;
        for (int[] sq : squares) {
            int lx = sq[0];
            int y = sq[1];
            int l = sq[2];
            int rx = lx + l;
            xs[n] = lx;
            xs[n + 1] = rx;
            events[n++] = new Event(y, lx, rx, 1);
            events[n++] = new Event(y + l, lx, rx, -1);
        }

        // 排序，方便离散化
        Arrays.sort(xs);

        // 初始化线段树
        SegmentTree t = new SegmentTree(xs);

        // 模拟扫描线从下往上移动
        Arrays.sort(events, (a, b) -> a.y - b.y);
        Record records[] = new Record[n - 1];
        long totArea = 0;
        for (int i = 0; i < n - 1; i++) {
            Event e = events[i];
            int l = Arrays.binarySearch(xs, e.lx); // 离散化
            int r = Arrays.binarySearch(xs, e.rx) - 1; // r 对应着 xs[r] 与 xs[r+1]=rx 的差值
            t.update(l, r, e.delta); // 更新被 [lx, rx] 覆盖的次数
            int sumLen = xs[n - 1] - xs[0] - t.getUncoveredLength(); // 减去没被矩形覆盖的长度
            records[i] = new Record(totArea, sumLen);
            totArea += (long) sumLen * (events[i + 1].y - e.y); // 新增面积 = 被至少一个矩形覆盖的底边长之和 * 矩形高度
        }

        // 找最后一个 < totArea / 2 的面积
        int i = 0;
        while (i < n - 1 && records[i].area * 2 < totArea) {
            i++;
        }
        i--;
        return events[i].y + (totArea - records[i].area * 2) / (records[i].sumLen * 2.0);
    }
}
