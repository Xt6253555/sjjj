package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

//对链表进行插入排序
public class demo147 {
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
        ListNode listNode = insertionSortList1(list1);
        list(listNode);
    }
    public static ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);

        ListNode pre = new ListNode(0);
        ListNode cur1 = pre;
        for (Integer b:list) {
            cur1.next = new ListNode(b);
            cur1 = cur1.next;
        }
        return pre.next;
    }
    public static ListNode insertionSortList1(ListNode head){
        if(head==null || head.next == null)return head;
        ListNode cur = new ListNode(0);
        ListNode pre = cur;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        Integer[] arr = list.toArray(new Integer[list.size()]);
        Integer[] insert = insert(arr);
        for (int i = 0; i < insert.length; i++) {
            pre.next = new ListNode(insert[i]);
            pre = pre.next;
        }
        return cur.next;
    }
    public static Integer[] insert(Integer[] arr){
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index= i-1;
            while (index>=0&&val<arr[index]){
                arr[index+1] =arr[index];
                index--;
            }
            arr[index+1] = val;
        }
        return arr;
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
