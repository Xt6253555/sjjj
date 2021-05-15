package JOffice;

import java.util.HashMap;

//复杂链表的复制
public class demo35 {
    public Node copyRandomList(Node head) {
        if(head==null)return head;
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur = head;
        while (cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
