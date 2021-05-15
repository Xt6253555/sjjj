package LinkedList;

public class demo4 {
    public static void main(String[] args) {
        //创建节点
        HeroNode2 hero1 = new HeroNode2(1, "a", "a1");
        HeroNode2 hero2 = new HeroNode2(2, "b", "b1");
        HeroNode2 hero3 = new HeroNode2(3, "d", "c1");
        //创建列表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.list();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero2);
//        LinkedList.HeroNode2 heroNode2 = new LinkedList.HeroNode2(3, "e", "e1");
//        doubleLinkedList.update(heroNode2);
//        doubleLinkedList.delete(3);
    }
}
//定义SingleLinkedList
class DoubleLinkedList{
    //初始化头节点
    private HeroNode2 head = new HeroNode2(0,"","");
    //返回头节点
    public HeroNode2 getHead(){
        return head;
    }
    //添加
    public void add(HeroNode2 heroNode){
        //添加辅助变量指向头节点
        HeroNode2 temp = head;
        //遍历链表
        //找到链表末尾
        while (true){
            if(temp.next == null){
                break;
            }
            //没有找到链表末尾,将temp向后移动
            temp = temp.next;
        }
        //退出循环，temp就指向了链表末尾
        //将最后节点指向新的节点（形成双向链表）
        temp.next=heroNode;
        heroNode.pre = temp;
    }
    //第二种添加，根据指定位置添加(如果有这个位置，则显示添加失败)
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no>heroNode.no){ //即找到了要插入的位置
                break;
            }else if(temp.next.no == heroNode.no){//添加的位置已经存在
                flag =true;//位置存在
                break;
            }
            temp = temp.next;//以上条件不成立后移，遍历当前链表
        }
        if(flag){
            System.out.println("编号存在"+heroNode.no);
        }else{
            heroNode.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = heroNode;
            }
            //插入到链表（temp）后面
            temp.next=heroNode;
            heroNode.pre = temp;

        }
    }
    //修改(和单项链表一致)
    public void update(HeroNode2 heroNode){
        //判断链表是否为空，即判断头节点
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if (temp.no == heroNode.no){
                //找到编号
                flag=true;
                break;
            }
            temp = temp.next;
        }
        //找到编号以后修改内容
        if(flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else {
            System.out.println("没有找到这个编号"+heroNode.no);
        }
    }
    //删除
    public void delete(int no){
        HeroNode2 temp = head.next;
        boolean flag =false;
        while (true){
            if(temp==null) {//遍历到链表结尾了
                break;
            }
            if(temp.no == no){//找到删除节点前一个temp
                flag =true;
                break;
            }
            temp = temp.next;//temp后移遍历
        }
        if (flag){
            //temp.next = temp.next.next;//单链表删除方法
            temp.pre.next=temp.next;
            //如果是最后一个节点执行下面报空指针异常
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("没有找到此节点,删除失败");
        }
    }
    //显示遍历方法
    public void list(){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //添加辅助变量指向头节点
        HeroNode2 temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            //输出链表
            System.out.println(temp);
            //将temp
            temp = temp.next;
        }
    }
}
class HeroNode2{
    public int no;
    public  String name;
    public  String nickname;
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;//指向前一个节点
    public HeroNode2(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "LinkedList.HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
