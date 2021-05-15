package LeetCode;
//687. 最长同值路径
public class demo687 {
    static int ans;
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.left = new TreeNode(4);
        l1.left.left = new TreeNode(4);
        l1.left.right = new TreeNode(4);
        longestUnivaluePath(l1);
    }
    public static int longestUnivaluePath(TreeNode root) {
        ans=0;
        depth(root);
        return ans;
    }
    public static int depth(TreeNode root) {
        if(root==null)return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        int l = 0,r=0;
        if(root.left!=null&&root.left.val==root.val) l+=left+1;
        if(root.right!=null&&root.right.val==root.val) r+=right+1;
        ans = Math.max(ans,l+r);
        return Math.max(l,r);
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
