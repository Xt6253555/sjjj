package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class demo187 {
    public static void main(String[] args) {
        long pre = Long.MIN_VALUE;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        HashSet<String> set = new HashSet();
        HashSet<String> ans = new HashSet();
        for (int start = 0; start < n - L + 1; start++) {
            String tmp = s.substring(start, start + L);
            if (set.contains(tmp)) {
                ans.add(tmp);
            }
            set.add(tmp);
        }
        return new ArrayList<String>(ans);
    }
}
