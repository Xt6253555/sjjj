package LeetCode;

import java.util.ArrayList;
import java.util.List;
//Z字形变换
public class demo6 {
    public static void main(String[] args) {
        String s = convert("PAYPALI", 3);
        System.out.println(s);
    }
    public static String convert(String s, int numRows){
        if(numRows<2)return s;
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int flag = -1;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(num).append(s.charAt(i));
            if(num==0||num==numRows-1){
                flag = -flag;
            }
            num+=flag;
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            builder.append(stringBuilder);
        }
        return builder.toString();
    }
}
