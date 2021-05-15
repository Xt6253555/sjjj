package LeetCode.test1;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(4);
        a.next =b;
        b.next =c;
        a1.next =b1;
        b1.next =c1;
        System.out.println(mergeTwoLists(a, a1));
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1!=null||l2!=null){
            int x = (l1 == null) ? Integer.MAX_VALUE : l1.val;
            int y = (l2 == null) ? Integer.MAX_VALUE : l2.val;
            if(x>y){
                cur.next = new ListNode(y);
                l2= l2.next;
            }else {
                cur.next = new ListNode(x);
                l1= l1.next;
            }
            cur = cur.next;
        }
        while (pre.next!=null){
            System.out.println(pre.next.val);
            pre.next =pre.next.next;
        }
        return pre.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
