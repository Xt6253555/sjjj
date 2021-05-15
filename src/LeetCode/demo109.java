package LeetCode;


import java.util.ArrayList;
import java.util.List;

//有序链表转换二叉搜索树
public class demo109 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        TreeNode treeNode = sortedListToBST(list1);
    }
    static private List<Integer> list;
    //求链表一共有多少个元素
    public static void count(ListNode head){
        list = new ArrayList<Integer>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
    }
    public static TreeNode convertListToBST(int left, int right) {
        if(left>right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        if(left==right){
            return node;
        }
        node.left = convertListToBST(left,mid-1);
        node.right = convertListToBST(mid+1,right);
        return node;
    }
    public static TreeNode convertListToBST1(int left, int right){
        if(left>right)return null;
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = convertListToBST1(left, mid - 1);
        node.right = convertListToBST1(mid+1,right);
        if(left==right)return node;
        return node;
    }
    public static TreeNode sortedListToBST(ListNode head) {
        //计算集合有多少个链表中的元素
        count(head);
        return convertListToBST(0,list.size()-1);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
