package JOffice;
//剑指 Offer 18. 删除链表的节点
public class demo18 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;l2.next = l3;l3.next = l4;
        deleteNode(l1,2);
    }
    public static ListNode deleteNode(ListNode head, int val) {
        if(head==null)return null;
        ListNode cur = new ListNode(0);
        cur.next = head;
        while (head!=null&&head.next!=null){
            if(head.next.val==val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return cur.next;
    }
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
