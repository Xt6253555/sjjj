package AVLTree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int arr[] = {4,3,6,5,7,8};
        AVLTree tree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历");
        tree.infixOrder();
        System.out.println(tree.getRoot().height());
        System.out.println(tree.getRoot().leftHeight());
        System.out.println(tree.getRoot().rightHeight());
    }
}
class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }
    //传入节点node（右节点），查找以node为根节点的二叉树最小结点的值
    public int delRightMin(Node node){
        Node target = node;
        while (target.left!=null){
            target=target.left;
        }
        delNode(target.value);
        return target.value;
    }
    //删除结点
    public void delNode(int value){
        if(root == null){
            return;
        }else {
            Node targetNode = search(value);
            //如果没有删除的节点
            if(targetNode==null){
                return;
            }
            if (root.left==null&&root.right==null){
                root=null;
                return;
            }
            //找到删除节点的父节点
            Node parent = searchParent(value);
            //如果是叶子节点
            if(targetNode.left==null&&targetNode.right==null){
                //是左子节点
                if(parent.left!=null&&parent.left.value==value){
                    parent.left=null;
                }else if(parent.right!=null&&parent.right.value==value){
                    parent.right=null;
                }
            }else if(targetNode.left!=null&&targetNode.right!=null){//删除有两颗子树的节点
                int min = delRightMin(targetNode.right);
                targetNode.value=min;
            }else {//删除只有一颗子树
                //如果删除节点有左子节点
                if(targetNode.left!=null){
                    if(parent!=null){
                        if(parent.left.value==value){
                            parent.left=targetNode.left;
                        }else{
                            parent.right=targetNode.left;
                        }
                    }else{
                        root=targetNode.left;
                    }
                }else {
                    if(parent!=null){
                        if(parent.left.value==value){
                            parent.left=targetNode.right;
                        }else{
                            parent.right=targetNode.right;
                        }
                    }else{
                        root=targetNode.right;
                    }
                }
            }
        }
    }
    //查找删除的节点
    public Node search(int value){
        if(root==null){
            return null;
        }else {
            return root.search(value);
        }
    }
    //查找删除的节点的父节点
    public Node searchParent(int value){
        if(root==null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }
    //添加方法
    public void add(Node node){
        if(root==null){
            root=node;
        }else {
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrder(){
        if(root!=null){
            root.infixOrder();
        }else {
            System.out.println("树为空");
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    //查找左子树高度
    public int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.height();
    }
    //查找右子树高度
    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.height();
    }
    //查找当前高度
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }
    //左旋转
    public void leftRotate(){
        Node newNode = new Node(value);
        newNode.left=left;
        newNode.right=right.left;
        value = right.value;
        right=right.right;
        left = newNode;
    }
    //右旋转
    public void rightRotate(){
        Node newNode = new Node(value);
        newNode.right=right;
        newNode.left=left.right;
        value=left.value;
        left=left.left;
        right=newNode;
    }
    //查找删除的节点
    public Node search(int value){
        if(value==this.value){
            return this;
        }else if(value<this.value){
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            if(this.right==null){
                return null;
            }
            return  this.right.search(value);
        }
    }
    //查找删除的节点的父节点
    public Node searchParent(int value){
        if((this.left!=null&&this.left.value==value)||
                this.right!=null&&this.right.value==value){
            return this;
        }else{
            if(value<this.value&&this.left!=null){
                return this.left.searchParent(value);
            }else if(value>=this.value&&this.right!=null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }
    //添加方法
    public void add(Node node){
        if(node==null){
            return;
        }
        if(node.value<this.value){
            if(this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
        //调用左旋转
        if(rightHeight()-leftHeight()>1){
            leftRotate();
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
}

