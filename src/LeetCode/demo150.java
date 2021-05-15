package LeetCode;

import java.util.Stack;

//150. 逆波兰表达式求值
public class demo150 {
    public static void main(String[] args) {
        String arr[] = {"4","13","5","/","+"};
        System.out.println(evalRPN(arr));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer a,b;
        for(String s: tokens){
            switch(s){
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a-b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a*b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a/b);
                    break;
                default :
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }
}
