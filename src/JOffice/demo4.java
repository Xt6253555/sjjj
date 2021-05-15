package JOffice;

import java.util.Arrays;
import java.util.Stack;
//从尾到头打印
public class demo4 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        System.out.println(Arrays.toString(reversePrint(l1)));
    }
    public static int[] reversePrint(ListNode head){
        int[]num = new int[0];
        if(head == null){
            return num;
        }
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] nums = new int[stack.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = stack.pop();
        }
        return nums;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        public void list(ListNode head){
            while(head!=null){
                System.out.println(head.val);
                head = head.next;
            }
        }
    }
}
