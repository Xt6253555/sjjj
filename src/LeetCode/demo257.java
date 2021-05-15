package LeetCode;

import java.util.ArrayList;
import java.util.List;

//257. 二叉树的所有路径
public class demo257 {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.left = new TreeNode(2);
        l1.right = new TreeNode(3);
        System.out.println(binaryTreePaths(l1));
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        return dfs(root,"",list);
    }
    public static List<String> dfs(TreeNode root, String path, List<String>list){
        if(root!=null){
            StringBuffer s= new StringBuffer(path);
            s.append(root.val);
            if(root.left==null&&root.right==null){
                list.add(s.toString());
            }else {
                s.append("->");
                dfs(root.left,s.toString(),list);
                dfs(root.right,s.toString(),list);
            }
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
