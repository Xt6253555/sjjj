package LeetCode;

import java.util.List;

//160相交链表
//[4,1,8,4,5],
//[5,6,1,8,4,5]
public class demo160 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);
        ListNode b4 = new ListNode(8);
        ListNode b5 = new ListNode(4);
        ListNode b6 = new ListNode(5);
        a1.next=a2;a2.next=a3;a3.next=a4;a4.next=a5;
        b1.next=b2;b2.next=b3;b3.next=b4;b4.next=b5;b5.next=b6;
        list(getIntersectionNode(a1,b1));
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null)return  null;
            ListNode pa = headA,pb = headB;
            while (pa != pb){
                pa = pa != null?pa.next:headB;
                pb = pb != null?pb.next:headA;
            }
            return pa;
    }
    public static void list(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
