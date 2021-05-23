package LeetCode;

import javax.print.attribute.standard.PresentationDirection;
import java.util.LinkedList;
import java.util.Stack;

//394字符串解码
// s = "3[a2[c]]"
public class demo394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int total = 0;
        LinkedList<String> str = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if(c<='9'&&c>='0')total = total*10+Integer.parseInt(c+"");
            else if(c=='['){
                str.addLast(sb.toString());
                num.addLast(total);
                total=0;
                sb= new StringBuilder();
            }else if(c==']'){
                StringBuilder tmp = new StringBuilder();
                Integer last = num.removeLast();
                for (Integer i = 0; i < last; i++)tmp.append(sb);
                sb = new StringBuilder(str.removeLast()+tmp);
            }else sb.append(c);
        }
        return sb.toString();
    }
}
