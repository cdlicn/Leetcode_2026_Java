import java.util.Arrays;

// TODO 3464. 正方形上的点之间的最大距离
public class Main_3464 {
    public int maxDistance(int side, int[][] points, int k) {
        // 正方形边上的点，按照顺时针映射到一维数轴上
        long[] a = new long[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (x == 0) {
                a[i] = y;
            } else if (y == side) {
                a[i] = side + x;
            } else if (x == side) {
                a[i] = side * 3L - y;
            } else {
                a[i] = side * 4L - x;
            }
        }
        Arrays.sort(a);

        int left = 1;
        int right = (int) (side * 4L / k) + 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(a, side, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(long[] a, int side, int k, int low) {
        next:
        for (long start : a) { // 枚举第一个点
            long end = start + side * 4L - low;
            long cur = start;
            for (int i = 0; i < k - 1; i++) { // 还需要找 k-1 个点
                int j = lowerBound(a, cur + low);
                if (j == a.length || a[j] > end) { // 不能离第一个点太近
                    continue next;
                }
                cur = a[j];
            }
            return true;
        }
        return false;
    }

    // 见 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(long[] nums, long target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
