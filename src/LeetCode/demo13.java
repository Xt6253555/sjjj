package LeetCode;

import java.util.HashMap;

//罗马数字转整数
public class demo13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0,i1= 0; i < symbols.length; i++,i1++) {
            map.put(symbols[i],values[i]);
        }
        int ans = 0;
        for (int i = 0; i < s.length();) {
            if(i<s.length()-1&&map.containsKey(s.substring(i,i+2))){
                ans = ans+map.get(s.substring(i,i+2));
                i=i+2;
            }else {
                ans = ans+map.get(s.substring(i,i+1));
                i++;
            }
        }
        return ans;
    }
}
