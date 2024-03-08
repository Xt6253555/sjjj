package LeetCode;

import java.util.Random;

//链表随机节点
public class demo382 {
    private  ListNode head;

    public demo382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        Random random = new Random();
        int res =0;
        int i =0;
        ListNode p = head;
        while (p!=null){
            i++;
            if(0==random.nextInt(i)){
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
