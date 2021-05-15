package LeetCode;
//669. 修剪二叉搜索树
public class demo669 {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.left = new TreeNode(0);
        l1.right = new TreeNode(2);
        System.out.println(trimBST(l1,1,2));
    }
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)return null;
        if(root.val<low){
            root = root.right;
            root = trimBST(root,low,high);
        }else if(root.val>low){
            root = root.left;
            root = trimBST(root,low,high);
        }else{
            root.right = trimBST(root.right,low,high);
            root.left = trimBST(root.left,low,high);
        }
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
