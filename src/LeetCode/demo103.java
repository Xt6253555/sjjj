package LeetCode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

//二叉树的锯齿形层序遍历
public class demo103 {
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
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        List<List<Integer>> list1 = new ArrayList<>();
        if(root == null){
            return list1;
        }
        queue.add(root);
        while (queue.size()>0){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            TreeNode curr = null;
            for (int i = 0; i < size; i++) {
                curr=queue.remove();
                list.add(curr.val);
                if (curr.right != null)
                    queue.add(curr.right);
                if (curr.left != null)
                    queue.add(curr.left);
            }
            list1.add(list);
        }
        List<List<Integer>> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if(i%2==1){
                list2.add(list1.get(i));
            }
            if(i%2==0) {
                List<Integer> list = new ArrayList<>();
                for (int size = list1.get(i).size()-1; size >= 0; size--) {
                    list.add(list1.get(i).get(size));
                }
                list2.add(list);
            }
        }
        return list2;
    }
    public static List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            if(count%2==0){
                Collections.reverse(list);
            }
            count++;
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
