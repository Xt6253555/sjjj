package LeetCode;

import java.util.HashSet;
import java.util.List;

//环形链表
public class demo141 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(4);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=list2;
        System.out.println(hasCycle(list1));
    }
    public static boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head!=null){
            hashSet.add(head);
            if(hashSet.contains(head.next)){
                return true;
            }
            head= head.next;
        }
        return false;
    }
    public static boolean hasCycle1(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast)return true;
        }
        return false;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
