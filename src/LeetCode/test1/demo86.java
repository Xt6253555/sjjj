package LeetCode.test1;

import java.util.Collections;

//分隔链表
public class demo86 {
    public static void main(String[] args) {

    }
    public static ListNode partition(ListNode head, int x) {
        if(head==null)return null;
        ListNode pre1 = new ListNode(0);
        ListNode cur1 = pre1;
        ListNode pre2 = new ListNode(0);
        ListNode cur2 = pre2;
        while (head!=null){
            if(head.val<x){
                cur1.next=new ListNode(head.val);
                cur1=cur1.next;
            }else {
                cur2.next=new ListNode(head.val);
                cur2=cur2.next;
            }
            head=head.next;
        }
        ListNode listNode = mergeTwoLists(pre1.next, pre2.next);
        return listNode;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
}
