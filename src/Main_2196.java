import java.util.HashMap;
import java.util.Map;

public class Main_2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Boolean> isRoot = new HashMap<>();
        for (int[] desc : descriptions) {
            TreeNode parent = map.getOrDefault(desc[0], new TreeNode(desc[0]));
            TreeNode child = map.getOrDefault(desc[1], new TreeNode(desc[1]));
            if (!isRoot.containsKey(parent.val)) {
                isRoot.put(parent.val, true);
            }
            isRoot.put(child.val, false);
            if (desc[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            map.put(parent.val, parent);
            map.put(child.val, child);
        }

        int root = -1;
        for (Map.Entry<Integer, Boolean> entry : isRoot.entrySet()) {
            if (entry.getValue()) {
                root = entry.getKey();
                break;
            }
        }
        return map.get(root);
    }
}
