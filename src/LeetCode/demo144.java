package LeetCode;

import java.util.ArrayList;
import java.util.List;
//144.二叉树的前序遍历
public class demo144 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.right = new TreeNode(2);
        l1.right.left = new TreeNode(3);
        System.out.println(preorderTraversal(l1));
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)return list;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
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
