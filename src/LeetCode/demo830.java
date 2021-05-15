package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 较大分组的位置
public class demo830 {
    public static void main(String[] args) {
        //System.out.println(largeGroupPositions("aaa").toString());
        for (int i = 0; i < 5; i++) {
            //System.out.println(i);
        }
        largeGroupPositions("aaa");
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        char[] chars = s.toCharArray();
        ArrayList<List<Integer>> list1 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            System.out.println(i);
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                if (count >= 2) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i - count);
                    list.add(i);
                    list1.add(list);
                }
                count = 0;
            } else {
                count++;
            }
        }
        return list1;
    }
}
