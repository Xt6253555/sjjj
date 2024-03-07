package LeetCode;

import java.util.List;

//N 叉树的最⼤深度
public class demo559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int subTreeMaxDepth = 0;
        for (Node child : root.children) {
            subTreeMaxDepth = Math.max(subTreeMaxDepth, maxDepth(child));
        }
        return 1 + subTreeMaxDepth;
    }
    public static class Node{
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
    }
}
