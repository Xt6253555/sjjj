package LeetCode;

import java.util.List;

//旋转链表
public class demo61 {
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
        ListNode listNode = rotateRight1(list1, 2);
        list(listNode);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode cur = head;
        //将链表变成环
        while (cur.next!= null) {
            length++;
            cur = cur.next;
        }
        cur.next = head;
        int step = k%length;
        ListNode temp = head;
        for (int i = 0; i < length-step-1; i++) {
            temp= temp.next;
        }
        ListNode res = temp.next;
        //断开环形链表
        temp.next=null;
        return res;
    }
    public static ListNode rotateRight1(ListNode head, int k){
        if(head==null||head.next==null)return head;
        int k1 = k%length(head);
        int k2 = length(head) - k1;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int i = 0; i < k1; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        while (slow!=null){
            cur.next = new ListNode(slow.val);
            cur = cur.next;
            slow = slow.next;
        }
        for (int i = 0; i < k2; i++) {
           cur.next = new ListNode(head.val);
           cur = cur.next;
           head = head.next;
        }
        return pre.next;
    }
    public static int length(ListNode head){
        int l = 0;
        while (head != null){
            l++;
            head = head.next;
        }
        return l;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void list(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
