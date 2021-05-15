package LeetCode;
//617. 合并二叉树
public class demo617 {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)return t2;
        if(t2==null)return t1;
        int x = t1 !=null?t1.val:0;
        int y = t2 !=null?t2.val:0;
        TreeNode root = new TreeNode(x+y);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
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
