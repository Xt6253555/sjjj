package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;

//146. LRU 缓存机制
public class demo146 {
    int cap;
    LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
    public demo146(int capacity) {
        this.cap=capacity;
    }

    public int get(int key) {
        if(!linkedHashMap.containsKey(key)){
            return -1;
        }
        makeRecent(key);
        return linkedHashMap.get(key);
    }

    public void put(int key, int value) {
        if(linkedHashMap.containsKey(key)){
            makeRecent(key);
            linkedHashMap.put(key, value);
            return;
        }
        if(linkedHashMap.size()>=cap){
            Integer next = linkedHashMap.keySet().iterator().next();
            linkedHashMap.remove(next);
        }
        linkedHashMap.put(key,value);
    }

    public void makeRecent(int key){
        Integer val = linkedHashMap.get(key);
        linkedHashMap.remove(key);
        linkedHashMap.put(key,val);
    }
}
