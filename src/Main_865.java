public class Main_865 {
    private int maxDepth = -1;
    private TreeNode res;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }

        int leftMaxDepth = dfs(node.left, depth + 1);
        int rightMaxDepth = dfs(node.right, depth + 1);

        if (leftMaxDepth == rightMaxDepth && leftMaxDepth == maxDepth) {
            res = node;
        }

        return Math.max(leftMaxDepth, rightMaxDepth);
    }
}
