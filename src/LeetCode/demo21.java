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
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1!=null||l2!=null){
            int x = (l1 == null) ? Integer.MAX_VALUE : l1.val;
            int y = (l2 == null) ? Integer.MAX_VALUE : l2.val;
            if(x>y){
                cur.next = new ListNode(y);
                l2= l2.next;
            }else {
                cur.next = new ListNode(x);
                l1= l1.next;
            }
            cur = cur.next;
        }
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
