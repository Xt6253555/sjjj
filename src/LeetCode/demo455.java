package LeetCode;

import java.util.Arrays;

//分发饼干
public class demo455 {
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0)return 0;
        int child =0;
        int cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (child<g.length&&cookie<s.length){
            if(g[child]<=s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }
}
