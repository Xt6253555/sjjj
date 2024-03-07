package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//打开转盘锁
public class demo752 {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadend = new HashSet<>();
        for (String s : deadends) deadend.add(s);
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int depth = 0;
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if(deadend.contains(cur))continue;
                if(cur.equals(target))return depth;
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
    // 将 s[j] 向上拨动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
