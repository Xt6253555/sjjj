package Tree;
//二叉树遍历
public class BinaryTree {
    public static void main(String[] args) {
        HeroNode a = new HeroNode(1, "a");
        HeroNode b = new HeroNode(2, "b");
        HeroNode c = new HeroNode(3, "c");
        HeroNode d = new HeroNode(4, "d");
        HeroNode e = new HeroNode(5, "e");
        a.setLeft(b);
        a.setRight(c);
        c.setRight(d);
        c.setLeft(e);
        System.out.println("前序");
        a.perOrder();
//        System.out.println("中序");
//        a.infixOrder();
//        System.out.println("后序");
//        a.postOrder();
//        HeroNode heroNode1 = a.perOrderSearch(5);
//        HeroNode heroNode2 = a.infixOrderSearch(5);
//        HeroNode heroNode3 = a.postOrderSearch(5);
//        System.out.println(heroNode1.getNo());
//        System.out.println(heroNode2.getNo());
//        System.out.println(heroNode3.getNo());
    }
}
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //前序遍历
    public void perOrder(){
        System.out.println(this);//this表示头节点
        //向左递归
        if(this.left!=null){
            this.left.perOrder();
        }
        //向右递归
        if(this.right!=null){
            this.right.perOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        //向左递归
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);//this表示头节点
        //向右递归
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        //向左递归
        if(this.left!=null){
            this.left.postOrder();
        }
        //向右递归
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);//this表示头节点
    }

    //前序查找
    public HeroNode perOrderSearch(int no){
        if(this.no==no){
            return this;
        }
        HeroNode resHode = null;
        //先遍历左边
        if(this.left!= null){
            resHode = this.left.perOrderSearch(no);
        }
        //即在左边找到了
        if(resHode!=null){
            return  resHode;
        }
        if(this.right!= null){
            resHode = this.right.perOrderSearch(no);
        }
        return resHode;
    }
    //中序查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resHode = null;
        //先遍历左边
        if(this.left!= null){
            resHode = this.left.infixOrderSearch(no);
        }
        //即在左边找到了
        if(resHode!=null){
            return  resHode;
        }
        if(this.no==no){
            return this;
        }
        if(this.right!= null){
            resHode = this.right.infixOrderSearch(no);
        }
        return resHode;
    }
    //后序查找
    public HeroNode postOrderSearch(int no){
        HeroNode resHode = null;
        //先遍历左边
        if(this.left!= null){
            resHode = this.left.postOrderSearch(no);
        }
        //即在左边找到了
        if(resHode!=null){
            return  resHode;
        }
        if(this.right!= null){
            resHode = this.right.postOrderSearch(no);
        }
        if(resHode!=null){
            return  resHode;
        }
        if(this.no==no){
            return this;
        }
        return resHode;
    }

}
