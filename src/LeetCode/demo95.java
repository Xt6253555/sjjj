package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//95.不同的二叉搜索树II
public class demo95 {
    public static List<TreeNode> generateTrees(int n) {
        if (n==0)return new ArrayList<>();
        return generateTrees(1,n);
    }
    public static List<TreeNode> generateTrees(int start,int end) {
        List<TreeNode> tree = new ArrayList<>();
        if(start>end){
            tree.add(null);
            return tree;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> treeLeft = generateTrees(start, i-1);
            List<TreeNode> treeRight = generateTrees(i+1, end);
            for (TreeNode left : treeLeft) {
                for (TreeNode right : treeRight) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    tree.add(node);
                }
            }
        }
        return tree;
    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
    }
}
