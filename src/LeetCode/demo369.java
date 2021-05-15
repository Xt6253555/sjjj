package LeetCode;

import java.util.ArrayList;
import java.util.List;

//369. 给单链表加一
public class demo369 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        plusOne(l1);
    }
    public static ListNode plusOne(ListNode head) {
        if(head == null) return head;
        ListNode node = rever(head);
        ListNode cur = new ListNode(0);
        ListNode pre = cur;
        int carry = 1;
        while (node!= null){
            int sum = node.val+carry;
            carry = sum/10;
            pre.next = new ListNode(sum%10);
            pre = pre.next;
            node = node.next;
        }
        if(carry>0){
            pre.next = new ListNode(carry);
        }
        ListNode rever = rever(cur.next);
        return rever;
    }
    public static ListNode rever(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null){
            ListNode t = pre.next;
            pre.next =cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
