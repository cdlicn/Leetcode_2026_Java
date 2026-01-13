public class Main_85 {

    int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] heights = new int[n + 1]; // 末尾多一个 0，理由见我 84 题题解
        int ans = 0;
        for (char[] row : matrix) {
            // 计算底边为 row 的柱子高度
            for (int j = 0; j < n; j++) {
                if (row[j] == '0') {
                    heights[j] = 0; // 柱子高度为 0
                } else {
                    heights[j]++; // 柱子高度加一
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights)); // 调用 84 题代码
        }
        return ans;
    }

    // 84. 柱状图中最大的矩形
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] st = new int[n]; // 用数组模拟栈
        int top = -1; // 栈顶下标
        st[++top] = -1; // 在栈中只有一个数的时候，栈顶的「下面那个数」是 -1，对应 left[i] = -1 的情况
        int ans = 0;
        for (int right = 0; right < n; right++) {
            int h = heights[right];
            while (top > 0 && heights[st[top]] >= h) {
                int i = st[top--]; // 矩形的高（的下标）
                int left = st[top]; // 栈顶下面那个数就是 left
                ans = Math.max(ans, heights[i] * (right - left - 1));
            }
            st[++top] = right;
        }
        return ans;
    }

}
