package LeetCode;

import java.util.HashMap;

//同构字符串
public class demo205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("aba","cdc"));
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()==0&&t.length()==0){
            return true;
        }
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))!=t.charAt(i)||
                    map1.containsKey(t.charAt(i))&&map1.get(t.charAt(i))!=s.charAt(i)){
                return false;
            }
           map.put(s.charAt(i),t.charAt(i));
           map1.put(t.charAt(i),s.charAt(i));
        }
        return true;
    }
}
