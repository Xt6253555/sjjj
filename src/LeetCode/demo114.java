package LeetCode;
//二叉树展开为链表
public class demo114 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left=b;
        a.right=e;
        b.left=c;
        b.right=d;
        e.right=f;
        per(a);


    }
    public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right!= null){
            p= p.right;
        }
        p.right = right;
    }
    //前序遍历
    public static TreeNode per(TreeNode root){
        if(root == null){
            return null;
        }
        System.out.println(root.val);
        if(root.left!=null){
            per(root.left);
        }
        if(root.right!=null){
            per(root.right);
        }
        return root;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}
