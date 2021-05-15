package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//30. 串联所有单词的子串
public class demo30 {
    public static void main(String[] args) {
        String s= "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String arr[] = {"fooo","barr","wing","ding","wing"};
        List<Integer> list = findSubstring(s, arr);
        for (int a:list) {
            System.out.println(a);
        }
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if(words==null||words.length==0){
            return res;
        }
        int wordNum = words.length;
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String word:words) {
            int value = allWords.getOrDefault(word, 0);
            allWords.put(word,value+1);
        }
        for (int i = 0; i < s.length()-wordLen * wordLen + 1; i++) {
            int count =0;
            HashMap<String, Integer> map = new HashMap<>();
            while (count<wordNum){
                String s1 = s.substring(i + count * wordLen, i + (count + 1) * wordLen);
                if(allWords.containsKey(s1)){
                    int orDefault = map.getOrDefault(s1, 0);
                    map.put(s1,orDefault+1);
                    if(map.get(s1)>allWords.get(s1)){
                        break;
                    }
                }else {
                    break;
                }
                count++;
            }
            if(count==wordNum){
                res.add(i);
            }
        }
        return res;
    }
}
