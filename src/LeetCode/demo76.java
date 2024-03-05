package LeetCode;

import java.util.HashMap;

//最小覆盖子串
public class demo76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0,right=0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        int valid = 0;
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c)))valid++;
            }
            while (need.size()==valid){
                if(right-left<len){
                    start=left;
                    len=right-left;
                }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d)))valid--;
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
