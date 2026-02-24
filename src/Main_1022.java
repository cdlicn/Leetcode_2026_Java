public class Main_1022 {

    int res = 0;

    public void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        val = (val << 1) | root.val;
        if(root.left == null && root.right == null) {
            res += val;
            return;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }
}
