package LeetCode;
//返回倒数第 k 个节点
public class demo02_02 {
    public int kthToLast(ListNode head, int k) {
        if(head == null || head.next == null)return head.val;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
