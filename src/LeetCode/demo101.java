package LeetCode;
//101. 对称二叉树
public class demo101 {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.left = new TreeNode(2);
        l1.left.left = new TreeNode(3);
        l1.right = new TreeNode(2);
        l1.right.right = new TreeNode(3);
        System.out.println(isSymmetric(l1));
    }
    public static boolean isSymmetric(TreeNode root) {
        return isSame(root,root);
    }
    public static boolean isSame(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if(t1.val==t2.val)
            return isSame(t1.left,t2.right)&&isSame(t1.right,t2.left);
        else
            return false;
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
