package LeetCode;
//337. 打家劫舍 III
public class demo337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));
    }
    public static int rob(TreeNode root) {
        int[] res = myRob(root);
        return Math.max(res[0],res[1]);
    }
    public static int[] myRob(TreeNode root){
        if(root==null)return new int[2];
        int res[] = new int[2];
        int[] left = myRob(root.left);
        int[] right = myRob(root.right);
        //0不偷，1偷
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = root.val+left[0]+right[0];
        return res;
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
