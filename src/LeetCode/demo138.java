package LeetCode;

public class demo138 {
    public static void main(String[] args) {
        Node list1 = new Node(1);
        Node list2 = new Node(2);
        Node list3 = new Node(3);
        list1.next=list2;
        list2.next=list3;
        list(copyRandomList(list1));
    }
    public static Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node p = head;
        //在每个原节点后面创建一个新节点
        while (p!=null){
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p=newNode.next;
        }
        p=head;
        //第二步，设置新节点的随机节点
        while(p!=null) {
            if(p.random!=null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        Node dummy = new Node(-1);
        p = head;
        Node cur = dummy;
        //第三步，将两个链表分离
        while(p!=null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        return dummy.next;
    }
    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void list(Node head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
