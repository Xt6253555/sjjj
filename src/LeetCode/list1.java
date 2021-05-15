package LeetCode;


import java.util.Stack;

//单链表操作
public class list1 {
    public static void main(String[] args) {
        HeroNode a = new HeroNode(1, "a", "a");
        HeroNode b = new HeroNode(2, "b", "b");
        HeroNode c = new HeroNode(3, "c", "c");
        HeroNode d = new HeroNode(4, "d", "d");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
//        singleLinkedList.add(a);
//        singleLinkedList.add(b);
//        singleLinkedList.add(c);
        //singleLinkedList.update(d);
        //singleLinkedList.delete(2);
        singleLinkedList.addByOrder(a);
        singleLinkedList.addByOrder(c);
        singleLinkedList1.addByOrder(b);
        singleLinkedList1.addByOrder(d);
//        int length = length(singleLinkedList.getHead());
//        System.out.println(length);
//        HeroNode index = findIndex(singleLinkedList.getHead(), 2);
        reversetList(singleLinkedList.getHead());
//        reversePrint(singleLinkedList.getHead());
        //singleLinkedList.list();
        //singleLinkedList1.list();

    }
    //获取单链表有效个数(不统计头节点)
    public static int length(HeroNode head){
        if(head.next==null){
            System.out.println("无有效节点");
        }
        int length = 0;
        HeroNode cur = head;
        while(true){
            if(cur.next!=null){
                length++;
                cur=cur.next;
            }else {
                break;
            }
        }
        return length;
    }
    //查找单链表中倒数第K个结点(链表长度-k+1)
    public static HeroNode findIndex(HeroNode head,int index){
        if (head.next==null){
            System.out.println("无有效节点");
        }
        int length = length(head);
        int size = length;
        if(size<0||index>size){
            return null;
        }
        HeroNode cur =head;
        for (int i = 0; i < size - index + 1; i++) {
            cur =cur.next;
        }
        return cur;
    }
    //单链表的反转
    public static void reversetList(HeroNode head){
        //链表只有一个节点或者没有直接返回
        if(head.next==null||head.next.next==null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;//辅助参数
        HeroNode New = new HeroNode(0,"","");
        while (cur!=null){
            next =cur.next;
            cur.next = New.next;
            New.next =cur;
            cur = next;//后移
        }
        head.next = New.next;
    }
    //逆序打印单链表
    public static  void reversePrint(HeroNode head){
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
//        for (int i = 0; i < stack.size()+2; i++) {
//            System.out.println(stack.pop());
//        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
    //合并两个单链表,使之有序
    public static  void merge(HeroNode head){

    }
}
class SingleLinkedList{
    //初始化头结点
    HeroNode head = new HeroNode(0, "", "");
    public HeroNode getHead(){
        return head;
    }
    //新增
    public void add(HeroNode heroNode){
        HeroNode temp =head;
        while(true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;//temp后移
        }
        temp.next=heroNode;
    }
    //第二种添加，
    public void addByOrder(HeroNode heroNode){
        HeroNode temp =head;
        boolean flag =false;
        while (true){
            if(temp.next==null){
                break;
            }
            if(temp.next.no>heroNode.no){
                break;
            }
            if(temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;//temp后移
        }
        if (flag){
            System.out.println("编号存在"+heroNode.no);
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }
    //更新(先找到更新编号，再更新)
    public void update(HeroNode heroNode){
        HeroNode temp =head.next;
        if (temp==null){
            System.out.println("链表为空");
        }
        boolean flag =false;
        while (true){
            if (temp==null){
                break;
            }
            if(temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
            if(flag){
                temp.name =heroNode.name;
                temp.NickName=heroNode.NickName;
            }else {
                System.out.println("没有找到这个节点,更新失败");
            }
        }
    }
    //删除
    public void delete(int no){
        HeroNode temp =head;
        boolean flag =false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next=temp.next.next;
        }else {
            System.out.println("没有找到这个节点，删除失败");
        }

    }
    //遍历
    public void list(){
        HeroNode temp =head;
        while(true){
            if(temp.next==null){
                break;
            }
            System.out.println(temp.next);
            temp=temp.next;
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public String NickName;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        NickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", NickName='" + NickName + '\'' +
                '}';
    }
}
