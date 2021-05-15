package LinkedList;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
    }
}
//创建一个环形链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);
    //添加小孩节点，构建成一个环形链表
    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，构建环形链表
        //使用for来创建我们的环形链表
        for (int i = 1; i < nums+1; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i==1){
                first = boy;
                first.setNext(first);//构成环
                curBoy=first;//curBoy指向第一个小孩
            }else{
                curBoy.setNext(boy);//curBoy指向下一个节点（boy）
                boy.setNext(first);//新节点指向头（first）
                curBoy=boy;//往后移
            }
        }
    }
    //遍历环形链表
    public  void showBoy(){
        //判断链表是否为空
        if(first == null){
            System.out.println("没有任何孩子");
            return;
        }
        Boy curBoy = first;//辅助节点用来遍历
        while (true){
            System.out.println("小孩编号"+curBoy.getNo());
            if (curBoy.getNext()==first){//遍历完成
                break;
            }
            curBoy = curBoy.getNext();//curBoy后移
        }
    }
}
class Boy{
    private int no;//编号
    private Boy next;//指向下一个节点，默认null

    public Boy(int no) {
        this.no = no;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
