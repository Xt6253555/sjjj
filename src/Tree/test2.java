package Tree;

import java.util.LinkedList;

public class test2 {
    private int count = 0;
    public int reletive_7 (int[] digit) {
        // write code here
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] flag = new boolean[digit.length];
        backtrace(digit,digit.length,track,flag);
        return  count;
    }
    public void backtrace(int[] nums,int size,LinkedList<Integer> track,boolean[]flag){
        if(track.size()==size&& check(track)){
            count++;
        }
        for (int i = 0; i < size; i++) {
            if(flag[i]){
                continue;
            }
            flag[i] = true;
            track.add(nums[i]);
            backtrace(nums,size,track,flag);
            track.pollLast();
            flag[i]=false;
        }

    }
    public  boolean check(LinkedList<Integer> list){
        StringBuilder s = new StringBuilder();
        for(int i :list){
            s.append(i);
        }
        int n = Integer.parseInt(s.toString());
        return n%7 == 0;
    }
}
