package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

//用队列实现栈
public class demo225 {
    public static void main(String[] args) {
        //1,3,7,15 31
        int sum = 1;
        int n = 49;
        int count = 0;
        for (int i = 1; i < n; i++) {
            sum+=2<<i-1;
        }
        System.out.println(2<<0);
    }
    private static Queue<Integer> queue;
    public demo225() {
        queue = new LinkedList<>();
    }
    public static void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
