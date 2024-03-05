package LeetCode;
//100.相同的树
public class demo100 {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.left = new TreeNode(2);
        l1.right = new TreeNode(3);
        TreeNode l2 = new TreeNode(1);
        l2.left = new TreeNode(2);
        l2.right = new TreeNode(3);

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        isString(p, s1);
        isString(q, s2);
        return s1.toString().equals(s2.toString());
    }
    public void isString(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(0);
            return;
        }
        sb.append(root.val);
        isString(root.left,sb);
        isString(root.right,sb);
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
