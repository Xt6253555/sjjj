package LeetCode.test1;

import LeetCode.demo114;
import LeetCode.demo206;

public class test2 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        System.out.println(reverseKGroup(a,3));
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if(tail==null)return head;
            tail = tail.next;
        }
        ListNode listNode = reverseList(head, tail);
        head.next = reverseKGroup(tail, k);
        return listNode;
    }
    //反转链表
    public static ListNode reverseList(ListNode head,ListNode tail) {
        if(head==null||head.next==null)return head;
        ListNode cur = null;
        ListNode pre = head;
        while (pre!=tail){
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        System.out.println(cur.val);
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
