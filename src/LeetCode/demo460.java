package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashSet;

//LFU 缓存机制
public class demo460 {
    // key 到 val 的映射，我们后文称为 KV 表
    HashMap<Integer, Integer> keyToVal;
    // key 到 freq 的映射，我们后文称为 KF 表
    HashMap<Integer, Integer> keyToFreq;
    // freq 到 key 列表的映射，我们后文称为 FK 表
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;

    public demo460(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }
    public int get(int key) {
        if(!keyToVal.containsKey(key))return -1;
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(this.cap<=0)return;
        if(keyToVal.containsKey(key)){
            keyToVal.put(key,value);
            increaseFreq(key);
            return;
        }
        if(this.cap<=keyToVal.size()){
            removeMinFreqKey();
        }
        keyToVal.put(key,value);
        keyToFreq.put(key,1);
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq=1;
    }

    //次数加1(更新kf，fk)
    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq+1,new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            if(freq==this.minFreq){
                this.minFreq++;
            }
        }
    }
    //移除最少使用的key
    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        Integer deleteKey = keyList.iterator().next();
        keyToVal.remove(deleteKey);
        keyToFreq.remove(deleteKey);
        keyList.remove(deleteKey);
        if(keyList.isEmpty()){
            freqToKeys.remove(this.minFreq);
        }
    }
}
