package LeetCode;

import java.util.LinkedList;

//449. 序列化和反序列化二叉搜索树
public class demo449 {
    //序列化二叉搜索树
    static String s= "";

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.left = new TreeNode(2);
        l1.right = new TreeNode(3);
        System.out.println(serialize(l1));
    }
    public static String serialize(TreeNode root) {
        if(root == null){
            s+="#"+",";
        }else{
            s+=root.val+",";
            serialize(root.left);
            serialize(root.right);
        }
        return s;
    }

    //反序列化二叉搜索树
    public static TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(",")) {
            nodes.addLast(s);
        }
        return create(nodes);
    }
    public static TreeNode create(LinkedList<String> nodes){
        if(nodes.isEmpty())return null;
        String s = nodes.removeFirst();
        if(s.equals("#"))return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = create(nodes);
        root.right = create(nodes);
        return root;
    }
    public static void list(TreeNode root){
        System.out.println(root.val);
        list(root.left);
        list(root.right);
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
