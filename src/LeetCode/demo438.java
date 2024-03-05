package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//找到字符串中所有字母异位词
public class demo438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c)))valid++;
            }
            while (valid==need.size()){
                if(right-left<=len){
                    len=right-left;
                    if(len==p.length())list.add(left);
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d)))valid--;
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return list;
    }
}
