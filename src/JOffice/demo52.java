package JOffice;
//52. 两个链表的第一个公共节点
public class demo52 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;

    }
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
