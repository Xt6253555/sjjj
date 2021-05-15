package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

//222. 完全二叉树的节点个数
public class demo222 {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.left = new TreeNode(2);
        l1.left.left = new TreeNode(4);
        l1.left.right = new TreeNode(5);
        l1.right = new TreeNode(3);
        l1.right.left = new TreeNode(6);
        System.out.println(countNodes(l1));
    }
    public static int countNodes(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count =0;
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            count++;
            if(node.left!=null)queue.add(node.left);
            if(node.right!=null)queue.add(node.right);
        }
        return count;
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
