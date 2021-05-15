package LeetCode;

import java.util.HashMap;

//146. LRU 缓存机制
public class demo146 {
    private HashMap<Integer,Node> map;
    private DoubleNode cache;
    private int capacity;
    public demo146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleNode();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key,val);
        return val;
    }

    public void put(int key, int value) {
        Node node = new Node(key,value);
        if(map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key,node);
        }else{
            if(capacity==cache.size()){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(node);
            map.put(key,node);
        }
    }
    class Node{
        int key;
        int val;
        Node next,prev;
        public Node(int key,int val){
            this.val = val;
            this.key = key;
        }
    }
    class DoubleNode{
        Node head = new Node(0,0);
        Node tail = new Node(0,0);
        int size;
        public DoubleNode(){
            head.next = tail;
            tail.next = head;
        }
        public void addFirst(Node node){
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;
        }
        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        public Node removeLast(){
            Node last = tail.prev;
            remove(last);
            return last;
        }
        public int size(){
            return size;
        }
    }
}
