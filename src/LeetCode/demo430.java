package LeetCode;

import java.net.HttpRetryException;

//扁平化多级双向链表
public class demo430 {
    public static void main(String[] args) {

    }
    //多级链表结构的扁平化类似二叉树的先序遍历
    //child就相当于left tree，next相当于right tree
    //需要维护一个prev指针用于访问当前节点的上一个节点
    //prev指针非空时，建立prev与当前节点的双向连接
    //处理完一个child后记得把它设为null
    public static Node flatten(Node head) {
        if(head ==null){
            return head;
        }
        dfs(head);
        return head;
    }
    static Node pre = null;
    public static void dfs(Node head){
        if(head==null){
            return;
        }
        Node next = head.next;
        if(pre!=null){
            pre.next=head;
            head.prev=pre;
        }
        pre=head;
        dfs(head.child.next);
        head.child=null;
        dfs(next);
    }
    public static class Node{
         int val;
         Node prev;
         Node next;
         Node child;
    }
}


