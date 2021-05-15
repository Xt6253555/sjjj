package Tree;

import java.util.ArrayList;
import java.util.Collections;

//创建赫夫曼树
public class HuffManTree {
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};
        Node root = createHuffMan(arr);
        preOrder(root);

    }
    public static void preOrder(Node root){
        if(root!=null){
            root.perOrder();
        }
    }
    public static Node createHuffMan(int[]arr){
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value:arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size()>1) {
            //集合排序
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //合并成新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        //返回根节点(集合仅一个节点)
        return nodes.get(0);
    }
}
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;
    //前序遍历
    public void perOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.perOrder();
        }
        if (this.right!=null){
            this.right.perOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //集合从小到大排序
        return this.value-o.value;
    }
}
