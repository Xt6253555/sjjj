package LeetCode;
//把二叉搜索树转换为累加树
public class demo538 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        b.left=a;
        b.right=c;
        convertBST(b);
    }
    static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
        if(root == null)return root;
        convertBST(root.right);
        sum = sum+root.val;
        root.val=sum;
        System.out.println(sum);
        convertBST(root.left);
        return root;
    }
    public static class TreeNode {
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
