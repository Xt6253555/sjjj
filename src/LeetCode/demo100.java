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
        System.out.println(ptree(l1));
        System.out.println(qtree(l2));
        System.out.println(isSameTree(l1,l2));

    }
    static StringBuilder p = new StringBuilder();
    static StringBuilder q = new StringBuilder();
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return ptree(p).equals(qtree(q));
    }
    public static String ptree(TreeNode root){
        if(root==null){
            p.append("null");
        }else{
            p.append(root.val);
            ptree(root.left);
            ptree(root.right);
        }
        return p.toString();
    }
    public static String qtree(TreeNode root){
        if(root==null){
            q.append("null");
        }else{
            q.append(root.val);
            qtree(root.left);
            qtree(root.right);
        }
        return q.toString();
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
