package LeetCode;
// 反转链表 II
public class demo92 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        ListNode listNode = reverseBetween1(list1,2,4);
        list(listNode);
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null||m==n) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next =head;
        ListNode node = pre;
        //找到需要反转的那一段的上一个节点。
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        ListNode cur = node.next;
        ListNode start = null;
        ListNode end = null;
        //反转链表
        for (int i = m; i <= n; i++) {
            start=cur.next;
            cur.next=end;
            end=cur;
            cur=start;//后移节点
        }
        //将反转前的起点的cur指向next
        node.next.next = cur;
        //将反转后的起点的end指向next
        node.next = end;
        return pre.next;
    }
    public static ListNode reverseBetween1(ListNode head, int m, int n){
        if(head==null || head.next==null)return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode(0);
        pre.next =head;
        ListNode cur = pre;
        for (int i = 1; i < m; i++) {
            if(slow==null)return head;
            slow =slow.next;
            cur = cur.next;
        }
        for (int i = 1; i < n; i++) {
            if(fast==null)return head;
            fast =fast.next;
        }
        ListNode end = fast.next;
        ListNode node = reverse1(slow, fast);
        cur.next = node;
        while (cur.next !=null){
            cur = cur.next;
        }
        cur.next = end;
        return pre.next;
    }
    //逆序打印到tail个节点的单链表
    private static ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = null;
        ListNode tmp = tail.next;
        while (head!=tmp){
            cur=head.next;
            head.next=pre;
            pre=head;
            head=cur;//后移节点
        }
        return pre;
    }
    private static ListNode reverse1(ListNode head, ListNode tail){
        ListNode pre = null;
        ListNode cur = head;
        ListNode node = tail.next;
        while (cur != node){
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
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
