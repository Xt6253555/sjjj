package LeetCode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

//二叉树的层序遍历
public class demo102 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        System.out.println(levelOrder(a).toString());
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        while (!tree.isEmpty()){
            int size = tree.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = tree.remove();
                list.add(temp.val);
                if(temp.left!=null)tree.add(temp.left);
                if(temp.right!=null)tree.add(temp.right);
            }
            res.add(list);
        }
        return res;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
