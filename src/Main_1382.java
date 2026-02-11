import java.util.ArrayList;
import java.util.List;

/**
 * @author cdlicn
 * @date 2026年02月09日 20:50
 * @description
 */

public class Main_1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nums = inorderTraversal(root);
        return sortedArrayToBST(nums);
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private void dfs(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(ans, node.left);  // 左
        ans.add(node.val);    // 根（这行代码移到前面就是前序，移到后面就是后序）
        dfs(ans, node.right); // 右
    }

    private TreeNode sortedArrayToBST(List<Integer> nums) {
        return buildBST(nums, 0, nums.size());
    }

    // 把 nums[left] 到 nums[right-1] 转成平衡二叉搜索树
    private TreeNode buildBST(List<Integer> nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int m = (left + right) >>> 1;
        return new TreeNode(nums.get(m), buildBST(nums, left, m), buildBST(nums, m + 1, right));
    }
}
