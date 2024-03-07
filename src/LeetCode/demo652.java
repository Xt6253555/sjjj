package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//寻找重复子树
public class demo652 {
    // 记录所有子树以及出现的次数
    HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode root) {
        //后序遍历查看是否有相同子树;
        if(root==null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String sub = left+','+right+','+root.val;
        Integer a = memo.getOrDefault(sub, 0);
        if(a==1){
            res.add(root);
        }
        // 给子树对应的出现次数加一
        if(!memo.containsKey(sub)){
            memo.put(sub, a + 1);
        }
        return  sub;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
