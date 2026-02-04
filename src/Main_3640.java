
// TODO 3640. 三段式数组 II
public class Main_3640 {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; ) {
            // 第一段
            int start = i;
            for (i++; i < n && nums[i - 1] < nums[i]; i++) ;
            if (i == start + 1) { // 第一段至少要有两个数
                continue;
            }

            // 第二段
            int peak = i - 1;
            long res = nums[peak - 1] + nums[peak]; // 第一段的最后两个数必选
            for (; i < n && nums[i - 1] > nums[i]; i++) {
                res += nums[i]; // 第二段的所有元素必选
            }
            if (i == peak + 1 || i == n || nums[i - 1] == nums[i]) { // 第二段至少要有两个数，第三段至少要有两个数
                continue;
            }

            // 第三段
            int bottom = i - 1;
            res += nums[i]; // 第三段的前两个数必选（第一个数在上面的循环中加了）
            // 从第三段的第三个数往右，计算最大元素和
            long maxS = 0;
            long s = 0;
            for (i++; i < n && nums[i - 1] < nums[i]; i++) {
                s += nums[i];
                maxS = Math.max(maxS, s);
            }
            res += maxS;

            // 从第一段的倒数第三个数往左，计算最大元素和
            maxS = 0;
            s = 0;
            for (int j = peak - 2; j >= start; j--) {
                s += nums[j];
                maxS = Math.max(maxS, s);
            }
            res += maxS;
            ans = Math.max(ans, res);

            i = bottom; // 第三段的起点也是下一个极大三段式子数组的第一段的起点
        }
        return ans;
    }
}
