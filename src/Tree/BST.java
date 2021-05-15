package Tree;

public class BST {
}
class BSTNode{
    int val;
    BSTNode left;
    BSTNode right;

    public BSTNode(int val) {
    }

    //普通搜索二叉树
    boolean isInBST(BSTNode root, int target) {
        if(root==null){
            return false;
        }
        if(root.val ==target){
            return true;
        }
        return isInBST(root.left,target)||
                isInBST(root.right,target);
    }
    //搜索二叉树
    boolean isInBST2(BSTNode root, int target) {
        if(root==null){
            return false;
        }
        if(root.val==target){
            return true;
        }
        if(root.val>target){
            return isInBST2(root.left,target);
        }
        if(root.val<target){
            return isInBST2(root.right,target);
        }
        return false;
    }

    //在 BST 中插入一个数
    public BSTNode insertIntoBST(BSTNode root, int val) {
        if(root==null){
            return  new BSTNode(val);
        }
        if(root.val<val){
            root.right = insertIntoBST(root.right, val);
        }
        if(root.val>val){
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    //在 BST 中删除一个数
    public BSTNode deleteNode(BSTNode root, int key) {
        if(root==null){
            return root;
        }
        if(root.val==key){
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            //删除节点有两个节点
            BSTNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }else if(root.val<key){
            root.right = deleteNode(root.right, key);
        }else if(root.val>key){
            root.left = deleteNode(root.left, key);
        }
            return  root;
    }
    public BSTNode getMin(BSTNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

}
