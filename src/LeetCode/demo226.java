package LeetCode;
//翻转二叉树
public class demo226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return  root;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public TreeNode invertTree1(TreeNode root){
        if(root == null)return null;
        invertTree1(root.left);
        invertTree1(root.right);
        TreeNode temp  = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
