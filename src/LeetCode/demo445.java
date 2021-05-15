package LeetCode;

import java.util.List;
import java.util.Stack;

//445. 两数相加 II
//输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
public class demo445 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(7);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(4);
        ListNode d1 = new ListNode(3);
        ListNode a2 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode c2 = new ListNode(4);
        a1.next=b1;b1.next=c1;c1.next=d1;
        a2.next=b2;b2.next=c2;
        System.out.println(addTwoNumbers1(a1,a2));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        while (l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode pre1 = new ListNode(0);
        ListNode cur = pre;
        ListNode cur1 = pre1;
        while (!s1.empty()||!s2.empty()){
            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();
            int sum = x+y+carry;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        while (pre.next!=null){
            s3.push(pre.next.val);
            pre.next= pre.next.next;
        }
        while (!s3.empty()){
            cur1.next = new ListNode(s3.pop());
            cur1 = cur1.next;
        }
        return pre1.next;
    }
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int temp = 0;
        ListNode cur = new ListNode(0);
        ListNode pre = cur;
        while (!s1.empty()||!s2.empty()){
            int x = (!s1.empty())?s1.pop():0;
            int y = (!s2.empty())?s2.pop():0;
            int sum = x+y+temp;
            temp = sum/10;
            pre.next  = new ListNode(sum % 10);
            pre =pre.next;
        }
        if(temp>0){
            pre.next = new ListNode(temp);
        }
        return rever(cur.next);
    }
    public static ListNode rever(ListNode head){
        ListNode cur = null;
        ListNode pre = head;
        while (pre!=null){
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
