package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//删除排序链表中的重复元素
public class demo83 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);
        ListNode list3 = new ListNode(1);
        ListNode list4 = new ListNode(3);
        ListNode list5 = new ListNode(3);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        ListNode listNode = deleteDuplicates(list1);
        list(listNode);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            int val = head.val;
            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }else {
                map.put(val,1);
            }
            head = head.next;
        }
        for (Integer a: map.keySet()) {
                list.add(a);
        }
        Collections.sort(list);
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (Integer b:list) {
            cur.next = new ListNode(b);
            cur = cur.next;
        }
        return pre.next;
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
