// TODO 3093. 最长公共后缀查询
public class Main_3093 {
    class Node {
        Node[] son = new Node[26];
        int minLen = Integer.MAX_VALUE; // 子树中的最短字符串的长度
        int bestIndex; // 子树中的最短字符串的下标
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Node root = new Node();
        for (int i = 0; i < wordsContainer.length; i++) {
            char[] s = wordsContainer[i].toCharArray();
            if (s.length < root.minLen) {
                root.minLen = s.length;
                root.bestIndex = i;
            }

            // 把 reverse(s) 插入字典树
            Node cur = root;
            for (int j = s.length - 1; j >= 0; j--) {
                int b = s[j] - 'a';
                if (cur.son[b] == null) {
                    cur.son[b] = new Node();
                }
                cur = cur.son[b];
                // 维护 cur 子树中的最短字符串的长度及其下标
                // 由于我们是按照 i 从小到大的顺序遍历，字符串长度相同时不更新 bestIndex
                if (s.length < cur.minLen) {
                    cur.minLen = s.length;
                    cur.bestIndex = i;
                }
            }
        }

        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String s = wordsQuery[i]; // 由于下面会中途退出循环，不转成 char[] 更快
            Node cur = root;
            for (int j = s.length() - 1; j >= 0 && cur.son[s.charAt(j) - 'a'] != null; j--) {
                cur = cur.son[s.charAt(j) - 'a'];
            }
            // 退出循环时，cur 即最长公共前缀（的对应节点），cur.bestIndex 是前缀为 cur 的最短字符串的下标
            ans[i] = cur.bestIndex;
        }
        return ans;
    }
}
