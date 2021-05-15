package LeetCode;

import java.security.Key;
import java.util.HashMap;

//字符串中的第一个唯一字符
public class demo387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
    public static int firstUniqChar(String s) {
        if(s.length()<=0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                map.put(chars[i],1);
            }else {
                map.put(chars[i],0);
            }
        }
        if(!map.containsValue(0)){
            return -1;
        }
        for(char c :map.keySet()){
            if(map.get(c)==0){
                for (int i = 0; i < chars.length; i++) {
                    if(chars[i]==c){
                        min = Math.min(min,i);
                    }
                }
            }
        }
        return min;
    }
}
