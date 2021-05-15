package LeetCode;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;

public class demo02_08 {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)return head;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (head!=null){
            if(map.containsKey(head)){
                return head;
            }else {
                map.put(head,1);
            }
            head = head.next;
        }
        return null;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
