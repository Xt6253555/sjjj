package LeetCode;
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807

//两数相加
public class demo2 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(7);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(4);
        ListNode d1 = new ListNode(3);
        ListNode a2 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        a1.next=b1;b1.next=c1;c1.next=d1;
        a2.next=b2;
        System.out.println(ListNode.print(addTwoNumbers(a1,a2)));
    }
    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;//记录进位
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1!=null||l2!=null){
            //取值
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x+y+carry;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            if(l1!=null){
                l1= l1.next;
            }
            if(l2!=null){
                l2= l2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
      public static String print(ListNode l){
          StringBuilder stringBuilder = new StringBuilder();
          while (l != null){
              stringBuilder.append(l.val);
              l=l.next;
          }
          return stringBuilder.toString();
      }
  }
}