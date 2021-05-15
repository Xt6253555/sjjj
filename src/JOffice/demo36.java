package JOffice;

import java.util.HashMap;

// 36. 二叉搜索树与双向链表
public class demo36 {
    public static void main(String[] args) {
    }
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node root) {
        if(root == null) return;
        dfs(root.left);
        if(pre != null){
            pre.right = root;
            root.left = pre;
        }else{
            head = root;
        }
        pre = root;
        dfs(root.right);
    }
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }
}
