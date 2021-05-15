package JOffice;
//链表中倒数第k个节点
public class demo22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null)return head;
        ListNode node = head;
        int lenght = 0;
        while (head!=null){
            head = head.next;
            lenght++;
        }
        for (int i = 1; i < lenght - k + 1; i++) {
            node = node.next;
        }
        return node;
    }
    public ListNode getKthFromEnd1(ListNode head, int k){
        if(head.next == null || head == null)return head;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
