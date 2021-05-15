package JUC;

import java.util.ArrayList;
import java.util.Collections;
//斗地主
public class Doudizhu {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("大王");
        list.add("小王");
        String[] color = {"黑桃","梅花","红心","方片"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        for (String c : color) {
            for (String n : numbers) {
                list.add(c+n);
            }
        }
        Collections.shuffle(list);
        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();
        ArrayList<String> C = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if(i>50){
                dipai.add(s);
            }else if(i%3==0){
                A.add(s);
            }else if(i%3==1){
                B.add(s);
            }else if(i%3==2){
                C.add(s);
            }
        }
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(dipai);
    }
}
