package LeetCode;

import java.util.LinkedList;
import java.util.List;

//N 叉树的后序遍历
public class demo590 {
    List<Integer> res = new LinkedList<>();
    public List<Integer> postorder(Node root) {
        traverse(root);
        return res;

    }
    void traverse(Node root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        for (Node child : root.children) {
            traverse(child);
        }
        // 后序遍历位置
        res.add(root.val);
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
