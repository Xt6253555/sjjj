package LeetCode;

import java.util.List;

//328. 奇偶链表
public class demo328 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        oddEvenList(l1);
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next == null)return head;
        ListNode cur = new ListNode(0);
        ListNode pre = cur;
        ListNode odd = head;
        ListNode even = head;
        int count =1;
        int num =1;
        while (odd != null){
            if(count%2 == 1){
                pre.next = new ListNode(odd.val);
                pre = pre.next;
            }
            count++;
            odd = odd.next;
        }
        while (even != null){
            if(num%2 == 0){
                pre.next = new ListNode(even.val);
                pre = pre.next;
            }
            num++;
            even = even.next;
        }
        return cur.next;
    }
    public static ListNode oddEvenList1(ListNode head){
        if(head==null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head,even=evenHead;
        while (even!=null&&even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
