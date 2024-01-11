package LeetCode;

//543. 二叉树的直径
public class demo543 {
    static int ans;
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.left = new TreeNode(2);
        l1.right = new TreeNode(3);
        l1.left.left = new TreeNode(4);
        l1.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(l1));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans-1;
    }
    public static int depth(TreeNode root) {
        if(root==null)return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        ans = Math.max(ans,l+r+1);
        return Math.max(l,r)+1;
    }
    public static class TreeNode{
        int x;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.x = x;
        }
    }
}
