package LeetCode;
//⼆叉搜索树节点最⼩距离
public class demo783 {
    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return res;
    }
    TreeNode prev = null;
    int res = Integer.MAX_VALUE;
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        if (prev != null) {
            res = Math.min(res, root.val - prev.val);
        }
        prev = root;
        traverse(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
