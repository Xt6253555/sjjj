package Tree;

public class TreeTest {
    public static void main(String[] args) {
        node a = new node(1, "a");
        node b = new node(2, "b");
        node c = new node(3, "c");
        node d = new node(4, "d");
        node e = new node(5, "e");
        a.setLeft(b);
        a.setRight(c);
//        c.setRight(d);
//        c.setLeft(e);
//        System.out.println("先序");
//        a.per();
//        System.out.println("中序");
//        a.mid();
//        System.out.println("后序");
//        a.post();
//        System.out.println(a.count(a));
//        a.invert(a);
        a.flatten(a);
        a.per();
    }

}
class node{
    private int no;
    private String name;
    private node left;
    private node right;
    private node next;

    public node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public node getLeft() {
        return left;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public node getRight() {
        return right;
    }

    public void setRight(node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    public void per(){
        System.out.println(this);
        if(this.left!=null){
            this.left.per();
        }
        if(right!=null){
            this.right.per();
        }
    }
    public void mid(){
        if(this.left!=null){
            this.left.mid();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.mid();
        }
    }
    public void post(){
        if(this.left!=null){
            this.left.post();
        }
        if(this.right!=null){
            this.right.post();
        }
        System.out.println(this);
    }
    //计算二叉树节点
    public int count(node node){
        if(node ==null){
            return 0;
        }
        return 1+count(node.left)+count(node.right);
    }
    //翻转二叉树
    public node invert(node root){
        if (root==null){
            return root;
        }
        //前序遍历交换节点
        node temp = root.left;
        root.left =root.right;
        root.right=temp;

        invert(root.left);
        invert(root.right);
        return root;
    }
    //填补二叉树右侧指针
    public node connect(node root){
        if (root ==null){
            return root;
        }
        twoConnect(root.left,root.right);
        return root;
    }
    public void twoConnect(node root1,node root2){
        if(root1==null||root2==null){
            return;
        }
        root1.next = root2;
        twoConnect(root1.left,root1.right);
        twoConnect(root2.left,root2.right);
        twoConnect(root1.right,root1.left);
    }
    //将二叉树展开成为一个单链表
    public void flatten(node root){
        if(root==null){
            return;
        }
        //左右子树已经被拉平成一条链表(递归调用)
        //左子树
        node left = root.left;
        //右子树
        node right = root.right;
        flatten(root.left);
        flatten(root.right);
        //将左子树作为根节点的右子树
        root.left=null;
        root.right=left;
        //连接原来的右子树，成为完整的链表
        node p=root;
        while(p.right!=null){
            p=p.right;
        }
        p.right = right;
    }
}
