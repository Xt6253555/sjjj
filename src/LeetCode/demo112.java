package LeetCode;

import java.util.ArrayList;
import java.util.List;

//112.路径总和
public class demo112 {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(5);
        l1.left = new TreeNode(4);
        l1.right = new TreeNode(8);
        l1.left.left = new TreeNode(11);
        l1.left.left.left = new TreeNode(7);
        l1.left.left.right = new TreeNode(2);
        l1.right.right = new TreeNode(3);
        System.out.println(dfs1(l1,0));
    }
    static ArrayList<Integer> list = new ArrayList<>();
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        int sum = 0;
        dfs(root,sum,targetSum);
        for (Integer a : list) {
            if(a==targetSum)return true;
        }
        return false;
    }
    public static List<Integer> dfs(TreeNode root, int sum, int targetSum){
        if(root!=null){
            sum+=root.val;
            if(root.left==null&&root.right==null&&sum==targetSum){
                list.add(sum);
            }else{
                dfs(root.left,sum,targetSum);
                dfs(root.right,sum,targetSum);
            }
        }
        return list;
    }
    public static boolean hasPathSum1(TreeNode root, int targetSum){
        if(root==null)return false;
        List<Integer> list = dfs1(root, root.val);
        for (Integer a : list) {
            if(a==targetSum){
                return true;
            }
        }
        return false;
    }
    public static List<Integer> dfs1(TreeNode root,int sum){
        if(root==null)return list;
        sum = sum+root.val;
        if(root.left==null&&root.right==null){
            list.add(sum);
        }else {
            dfs1(root.left,sum);
            dfs1(root.right,sum);
        }
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
