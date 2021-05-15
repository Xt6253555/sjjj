package LeetCode;

import java.util.Arrays;

//379. 电话目录管理系统
public class demo379 {
    public static void main(String[] args) {
        demo379 a1 = new demo379(1);
        a1.get();
    }
    private boolean[] phone;
    private int size;
    public demo379(int maxNumbers) {
        this.size = maxNumbers;
        phone = new boolean[maxNumbers];
        Arrays.fill(phone,true);
    }
    public int get() {
        for (int i = 0; i < size; i++) {
            if (phone[i]){
                phone[i] = false;
                return i;
            }
        }
        return -1;
    }

    public boolean check(int number) {
        return phone[number];
    }

    public void release(int number) {
        phone[number] = true;
    }
}
