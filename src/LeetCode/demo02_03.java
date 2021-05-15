package LeetCode;
//面试题 02.03. 删除中间节点
//如果要删掉B节点,那么只需要将 B 变为 C，再把 B 的指针指向 D，即可完成。
public class demo02_03 {
    public void deleteNode(ListNode node) {
        if(node==null)return;
        //B 变为 C
        node.val = node.next.val;
        //B 的指针指向 D
        node.next = node.next.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
