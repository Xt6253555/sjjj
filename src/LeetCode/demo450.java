package LeetCode;
//删除二叉搜索树中的节点
public class demo450 {
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

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(7);
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.right=f;
        deleteNode(a,3);
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root ==null){
            return root;
        }
        if(root.val == key){
            if(root.left==null)return root.right;
            if(root.right==null)return root.left;
            TreeNode min = getMin(root.right);
            root.val  =  min.val;
            root.right = deleteNode(root.right,min.val);
        }
        if(root.val>key){
            root.left = deleteNode(root.left,key);
        }
        if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
    public static TreeNode getMin(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}
