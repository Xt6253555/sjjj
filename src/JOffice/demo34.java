package JOffice;

import java.util.ArrayList;
import java.util.List;

//二叉树中和为某一值的路径
public class demo34 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return pathSum(root,sum,new ArrayList<>());
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum,
                                       List<Integer>list){
        if(root==null)return res;
        List<Integer> sub = new ArrayList<>(list);
        sub.add(root.val);
        sum-=root.val;
        if(sum==0&&root.left==null&&root.right==null){
            res.add(sub);
        }
        pathSum(root.left,sum,sub);
        pathSum(root.right,sum,sub);
        return res;
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
