package JOffice;

import java.util.HashMap;

//重建二叉树
public class demo5 {
    public static void main(String[] args) {
    }
    HashMap<Integer, Integer> dic = new HashMap<>();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root1, int left, int right) {
        if(left > right) return null;
        TreeNode root = new TreeNode(po[root1]);
        int i = dic.get(po[root1]);
        root.left = recur(root1 + 1, left, i - 1);
        root.right = recur(root1 + i - left + 1, i + 1,right);
        return root;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
}
