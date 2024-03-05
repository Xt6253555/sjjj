package LeetCode;

import java.util.List;

//删除单链表倒数第N个节点
public class demo19 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        removeNthFromEnd(list1, 2);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null)return head;
        ListNode pre = new ListNode(0);
        pre.next =head;
        ListNode slow = pre;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
    public static class ListNode {
      int val;
      ListNode next;
      public ListNode(int x){
          val = x;
      }
    }
}
