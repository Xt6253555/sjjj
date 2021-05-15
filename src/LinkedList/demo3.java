package LinkedList;

import java.util.Stack;

public class demo3 {
    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "a", "a1");
        HeroNode hero2 = new HeroNode(2, "b", "b1");
        HeroNode hero3 = new HeroNode(3, "c", "c1");
        //创建要给的链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //添加节点到链表中
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        //按照编号插入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        //测试修改节点
        //singleLinkedList.update(new LinkedList.HeroNode(2,"d","d1"));
        //删除节点
        //singleLinkedList.delete(1);
        //singleLinkedList.list();
        //System.out.println(length(singleLinkedList.getHead()));
        //System.out.println(findIndex(singleLinkedList.getHead(),2));
        //单链表反转
        //reversetList(singleLinkedList.getHead());
        //reversePrint(singleLinkedList.getHead());
        singleLinkedList.list();
    }
    //获取单链表有效个数(不统计头节点)
    public static int length(HeroNode head){
        if(head.next==null){
            System.out.println("空链表");
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
    //查找单链表中倒数第K个结点(链表长度-k+1)
    public static HeroNode findIndex(HeroNode head,int index){
        if(head.next == null){
            System.out.println("链表为空");
        }
        int size = length(head);
        if(index<0||index>size){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur= cur.next;
        }
        return cur;
    }
    //单链表的反转
    public static void reversetList(HeroNode head){
        //链表只有一个节点或者没有直接返回
        if (head.next == null || head.next.next==null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null){
            next = cur.next;
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next=cur;//新的链表的最前端指向头节点
            cur = next;//cur后移
        }
        //将head.next指向reverseHead.next,实现单链表的反转
        head.next = reverseHead.next;
    }
    //逆序打印单链表
    public static  void reversePrint(HeroNode head){
        if(head.next ==null){
            return;
        }
        //用压栈方法逆序打印单链表
        Stack<HeroNode> s = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            s.push(cur);
            cur = cur.next;
        }
        while (s.size()>0){
            System.out.println(s.pop());
        }
    }
}
//定义SingleLinkedList
class SingleLinkedList{
    //初始化头节点
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        //添加辅助变量指向头节点
        HeroNode temp = head;
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
        //将最后节点指向新的节点
        temp.next=heroNode;
    }
    //第二种添加，根据指定位置添加(如果有这个位置，则显示添加失败)
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
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
            //插入到链表（temp）后面
            heroNode.next= temp.next;
            temp.next = heroNode;
        }
    }
    //修改，根据编号修改
    public void update(HeroNode heroNode){
        //判断链表是否为空，即判断头节点
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
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
        HeroNode temp = head;
        boolean flag =false;
        while (true){
            if(temp.next==null) {//遍历到链表结尾了
                break;
            }
            if(temp.next.no == no){//找到删除节点前一个temp
                flag =true;
                break;
            }
            temp = temp.next;//temp后移遍历
        }
        if (flag){
            temp.next = temp.next.next;//删除方法
        }else{
            System.out.println("没有找到此节点");
        }
    }
    //遍历链表
    public void list(){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //添加辅助变量指向头节点
        HeroNode temp = head.next;
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
class HeroNode{
    public int no;
    public  String name;
    public  String nickname;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no,String name,String nickname){
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
