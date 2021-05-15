package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//排序链表(归并排序)
//要求：在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//154326
public class demo148 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(3);
        ListNode list3 = new ListNode(2);
        ListNode list4 = new ListNode(5);
        ListNode list5 = new ListNode(4);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        ListNode listNode = sortList(list1);
        list(listNode);
    }
    public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        //先分解，找到中点断开，使用递归继续分解
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        //递归完成再进行合并
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left!=null&&right!=null){
            if(left.val<right.val){
                h.next =left;
                left = left.next;
            }else {
                h.next =right;
                right = right.next;
            }
            h=h.next;
        }
        //将第一个值赋值给h.next
        h.next = left != null ? left : right;
        return res.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void list(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head= head.next;
        }
    }
}
