package LeetCode;

import java.util.ArrayList;
import java.util.List;

//回文列表
public class demo234 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(-129);
        ListNode listNode1 = new ListNode(-129);
        listNode.next = listNode1;
        System.out.println(isPalindrome(listNode));
    }
    public static boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null)return true;
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if(!list.get(i).equals(list.get(list.size()-1-i))){
                return false;
            }
        }
        return true;
    }
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}
