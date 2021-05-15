package LeetCode;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(2);
        System.out.println(yesterday);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = head;
        ListNode cur = head.next;
        dummy.next = head;
        while (cur != null) {
            if (pre.val <= cur.val) {// 本来就有序
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                // 找到一个位置使得p < cur < p.next
                while (p.next != cur && p.next.val < cur.val) {
                    p = p.next;
                }
                pre.next = cur.next;
                //交换两个位置（p.next和cur）
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
//                反转节点
//                ListNode pre = null;
//                ListNode next = null;
//                while (head!=null){
//                    next=head.next;
//                    head.next=pre;
//                    pre=head;
//                    head=next;
//                }
            }
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public static void list(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head= head.next;
        }
    }
}
