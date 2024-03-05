package LeetCode;
//合并两个有序单链表
public class demo21 {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        ListNode list0 = new ListNode(0);
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        list0.next=list1;
        list2.next=list3;
        ListNode listNode = mergeTwoLists(list0, list2);
        node.list(listNode);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1==null?l2:l1;
        return pre.next;
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
      public static void list(ListNode listNode){
            ListNode temp = listNode;
            while (true){
                if(temp == null){
                    break;
                }
                //输出链表
                System.out.println(temp.val);
                //将temp
                temp = temp.next;
            }
      }
    }
}
