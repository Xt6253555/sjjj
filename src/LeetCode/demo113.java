package LeetCode;

import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

//113. 路径总和 II
public class demo113 {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.left = new TreeNode(12);
        l1.right = new TreeNode(3);
        System.out.println(pathSum(l1, 4));
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,targetSum,new ArrayList<>(),res);
        return res;
    }
    public static void dfs(TreeNode root, int sum, List<Integer> list,
                    List<List<Integer>> result) {
        if (root == null)return;
        List<Integer> subList = new ArrayList<>(list);
        subList.add(root.val);
        if(root.left==null&&root.right==null){
            if(sum == root.val){
                result.add(subList);
            }
            return;
        }
        dfs(root.left,sum-root.val,subList,result);
        dfs(root.right,sum-root.val,subList,result);
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
