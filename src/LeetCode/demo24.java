package LeetCode;

public class demo24 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        ListNode listNode = swapPairs(list1);
        list(listNode);
    }
    public static ListNode swapPairs(ListNode head) {
        // 1. 终止条件：当前没有节点或者只有一个节点，肯定就不需要交换了
        if (head == null || head.next == null) {
            return head;
        }
        // 2. 调用单元
        // 需要交换的两个节点是 head 和 head.next
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        // firstNode 连接后面交换完成的子链表
        firstNode.next = swapPairs(secondNode.next);
        // secondNode 连接 firstNode
        secondNode.next= firstNode;
        // 3. 返回值：返回交换完成的子链表
        // secondNode 变成了头结点
        return secondNode;
    }
    public static ListNode swapPairs1(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs1(second.next);
        second.next = first;
        return second;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static void list(ListNode listNode){
        ListNode temp = listNode;
        while (true){
            if(temp == null){
                break;
            }
            //输出链表
            System.out.println(temp.val);
            //将temp
            temp = temp.next;
        }
    }
}

