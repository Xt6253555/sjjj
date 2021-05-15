package JOffice;
//25. 合并两个排序的链表
public class demo25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null || l2 !=null){
            int x = l1!=null?l1.val:Integer.MAX_VALUE;
            int y = l2!=null?l2.val:Integer.MAX_VALUE;
            if(x<y){
                cur.next = new ListNode(x);
                l1 = l1.next;
            }else{
                cur.next = new ListNode(x);
                l2=l2.next;
            }
            cur = cur.next;
        }
        return pre.next;
    }
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
