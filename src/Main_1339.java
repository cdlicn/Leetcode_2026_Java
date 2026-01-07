import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_1339 {

        long sum = 0;
        static final long MOD = 1_000_000_007;
        long res = 0;


        int dfs(TreeNode node) {
            if (node == null) return 0;
            int tmp = node.val + dfs(node.left) + dfs(node.right);
            res = Math.max(res, tmp * (sum - tmp));
            return tmp;
        }

        public int maxProduct(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            dfs(root);
            return (int) (res % MOD);
        }

}
