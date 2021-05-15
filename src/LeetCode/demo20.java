package LeetCode;

import java.util.*;

//20. 有效的括号
public class demo20 {
    public static void main(String[] args) {
        System.out.println(isValid("([])()"));
    }
    public static boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        for (char c :s.toCharArray()) {
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.empty()||c!=stack.pop()){
                return false;
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
