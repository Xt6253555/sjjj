package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//无重复字符的最长子串(滑动窗口)
public class demo3 {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring1("pweke");
        System.out.println(length);
    }
    public static int lengthOfLongestSubstring(String s){
        if(s.length()==0)return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                sum = Math.max(sum,map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i+1);
            l = Math.max(l,i+1-sum);
        }
        return l;
    }
    public static int lengthOfLongestSubstring1(String s){
        if(s.length()<2||s==null)return s.length();
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
