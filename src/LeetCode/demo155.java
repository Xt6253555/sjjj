package LeetCode;

import java.util.Stack;

//155.最小栈
public class demo155 {
    public static void main(String[] args) {
        demo155 minStack = new demo155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
    private Stack<Integer> stack;
    private Stack<Integer> MinStack;
    public demo155() {
        stack = new Stack<>();
        MinStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(MinStack.isEmpty()||x<=MinStack.peek()){
            MinStack.push(x);
        }
    }
    public void pop() {
        if(stack.pop().equals(MinStack.peek())){
            MinStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return MinStack.peek();
    }
}
