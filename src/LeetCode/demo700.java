package LeetCode;
//⼆叉搜索树中的搜索
public class demo700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) return searchBST(root.left, val);
        if (root.val < val) return searchBST(root.right, val);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
