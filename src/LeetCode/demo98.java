package LeetCode;
//98. 验证二叉搜索树
public class demo98 {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(1);
        TreeNode l3 = new TreeNode(3);
        l1.left = l2; l1.right = l3;
        isValidBST(l1);
    }
    static long pre = Long.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val<=pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
