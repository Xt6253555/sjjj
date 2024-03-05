package LeetCode;

import java.util.HashMap;

//字符串的排列
public class demo567 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left=0;
        int right=0;
        int valid=0;
        int len=Integer.MAX_VALUE;
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i),need.getOrDefault(s1.charAt(i),0)+1);
        }
        while (right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c)))valid++;
            }
            while (valid==need.size()){
                if(right-left<len){
                    len=right-left;
                }
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d)))valid--;
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return len == s1.length();
    }
}
