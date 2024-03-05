package LeetCode;

import java.util.ArrayList;

//合并k个排序链表
public class demo23 {
    public static void main(String[] args) {
        ListNode list0 = new ListNode(0);
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(1);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list0.next=list1;
        list2.next=list3;
        list4.next=list5;
        ListNode[] arr={list0,list2,list4};
        ListNode listNode = mergeKLists(arr);
        list(listNode);
    }
    //分治合并链表（不断合并两个链表，直到数组只有一个）
    public static ListNode mergeKLists(ListNode[] lists) {
        int len =lists.length;
        if(len==0){
            return null;
        }
        while (len>1){
            for (int i = 0; i < (len / 2); i++) {
                lists[i]=mergeTwoLists(lists[i],lists[len-1-i]);
            }
            len=(len+1)/2;
        }
        return lists[0];
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode pre = cur;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return cur.next;
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      ListNode() { }
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
