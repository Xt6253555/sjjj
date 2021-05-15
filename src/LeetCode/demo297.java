package LeetCode;

import java.util.LinkedList;

//二叉树的序列化与反序列化
public class demo297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
  }
    String SEP = ",";
    String NULL = "#";
    //序列化，二叉树变成字符串
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(NULL).append(SEP);
        }
        sb.append(root.val).append(SEP);
        serialize(root.left);
        serialize(root.right);
    }
    //反序列化，字符串变成二叉树
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }
    public TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty())return null;
        String s = nodes.removeFirst();
        if(s.equals(NULL))return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
