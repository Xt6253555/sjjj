package LeetCode;
//反转一个单链表
public class demo206 {
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
        System.out.println(reverseList1(a,b));
    }
    public static ListNode reverseList1(ListNode head,ListNode tail) {
        if(head==null||head.next==null)return head;
        ListNode cur = null;
        ListNode pre = head;
        while (pre!=tail){
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        while (cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
        return cur;
    }
    public static ListNode reverseList(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode cur = null;
        ListNode pre = head;
        while (pre!=null){
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
