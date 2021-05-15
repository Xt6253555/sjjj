package LeetCode;
//k个一组翻转链表
public class demo25 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        //ListNode reverse = reverse(list1, list3);
        ListNode listNode = reverseKGroup(list1, 2);
        list(listNode);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        //没有节点或者只有一个节点直接返回
        if (head==null||head.next==null){
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if(tail==null){
                return head;
            }
            tail=tail.next;//后移
        }
        //获取反转后的链表
        ListNode reverse = reverse(head, tail);
        //递归获取下一个节点
        head.next = reverseKGroup(tail, k);
        return reverse;
    }
    public static ListNode reverseKGroup1(ListNode head, int k){
        if(head==null || head.next == null)return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if(tail==null)return head;
            tail = tail.next;
        }
        ListNode node = reverse1(head, tail);
        head.next = reverseKGroup1(tail,k);
        return node;
    }
    //逆序打印到tail个节点的单链表
    private static ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head!=tail){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;//后移节点
        }
        return pre;
    }
    public static ListNode reverse1(ListNode head, ListNode tail){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail){
            ListNode t = cur.next;
            cur.next = pre;
            pre = head;
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
