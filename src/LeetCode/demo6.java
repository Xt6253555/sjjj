package LeetCode;

import java.util.ArrayList;
import java.util.List;
//Z字形变换
public class demo6 {
    public static void main(String[] args) {
        String s = convert("PAYPALI", 3);
        System.out.println(s);
    }
    public static String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        //把字符串分成numRows份
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        //赋值给它相应的字符串
        int i =0,flag=-1;
        for (int j = 0; j < s.length(); j++) {
            list.get(i).append(s.charAt(j));
            if(i==0||i==numRows-1){
                flag=-flag;
            }
            i+=flag;
        }
        //最后进行拼接
        StringBuilder builder = new StringBuilder();
        for (StringBuilder stringBuilder :list) {
            builder.append(stringBuilder);
        }
        return builder.toString();
    }
}
