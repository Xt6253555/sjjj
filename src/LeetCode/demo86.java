package LeetCode;
//分隔链表
public class demo86 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(4);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(2);
        ListNode list5 = new ListNode(5);
        ListNode list6 = new ListNode(2);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=list6;
        ListNode listNode = partition1(list1,3);
        list(listNode);
    }
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode listNode = pre;
        ListNode cur = head;
        while (head!=null){
            if (head.val < x){
                listNode.next = new ListNode(head.val);
                listNode = listNode.next;
                head = head.next;
            }else {
                head = head.next;
            }
        }
        while (cur!=null){
            if (cur.val >= x){
                listNode.next = new ListNode(cur.val);
                listNode = listNode.next;
                cur = cur.next;
            }else {
                cur = cur.next;
            }
        }
        return pre.next;
    }
    public static ListNode partition1(ListNode head, int x){
        if(head==null || head.next == null)return head;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        ListNode min = head;
        ListNode max = head;
        while (min != null){
            if(min.val<x){
                cur.next = new ListNode(min.val);
                cur = cur.next;
            }
            min = min.next;
        }
        while (max != null){
            if(max.val>=x){
                cur.next = new ListNode(max.val);
                cur = cur.next;
            }
            max = max.next;
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
