package LeetCode;

import java.util.*;
import java.util.concurrent.BlockingQueue;

//107. 二叉树的层序遍历 II
public class demo107 {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(3);
        l1.left = new TreeNode(9);
        l1.right = new TreeNode(20);
        l1.right.left = new TreeNode(15);
        l1.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(l1));
        lerverList1(l1);
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)return new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<List<Integer>> tree = new ArrayList<>();
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            TreeNode temp;
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                temp = queue.remove();
                list.add(temp.val);
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
            tree.add(list);
        }
        Collections.reverse(tree);
        return tree;
    }
    public static List<List<Integer>> levelOrderBottom1(TreeNode root){
        if(root == null) return new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> tree = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode temp;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                temp = queue.remove();
                list.add(temp.val);
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
            tree.add(list);
        }
        Collections.reverse(tree);
        return tree;
    }
    public static TreeNode lerverList(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        while (!queue.isEmpty()){
            temp = queue.remove();
            System.out.println(temp.val);
            if(temp.left!=null)queue.add(temp.left);
            if(temp.right!=null)queue.add(temp.right);
        }
        return root;
    }
    public static TreeNode lerverList1(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            System.out.println(temp.val);
            if(temp.left!=null)queue.add(temp.left);
            if(temp.right!=null)queue.add(temp.right);
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
