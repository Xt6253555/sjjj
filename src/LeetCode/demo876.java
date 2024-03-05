package LeetCode;

//链表的中间结点
public class demo876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
        }
    }
}
