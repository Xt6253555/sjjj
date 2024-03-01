package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//无重复字符的最长子串(滑动窗口)
public class demo3 {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("pweke");
        System.out.println(length);
    }
    public static int lengthOfLongestSubstring(String s){
        if (s.length() < 2) return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                sum = Math.max(sum,map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i+1);
            max = Math.max(max,i+1-sum);
        }
        return max;
    }
    public static int lengthOfLongestSubstring1(String s){
        if(s.length()<2)return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                sum = Math.max(sum,map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i+1);
            max = Math.max(max,i+1-sum);
        }
        return max;
    }
}
