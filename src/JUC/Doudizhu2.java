package JUC;

import java.util.*;

//斗地主（牌有序）
public class Doudizhu2 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        List<String> color = Arrays.asList("黑桃","梅花","红心","方片");
        List<String> numbers = Arrays.asList("2","A","K","Q","J","10","9","8","7","6","5","4","3");
        int index = 0;
        map.put(index,"大王");
        list.add(index);
        index++;
        map.put(index,"小王");
        list.add(index);
        index++;
        for (String n : numbers) {
            for (String c : color) {
                map.put(index,c+n);
                list.add(index);
                index++;
            }
        }
        Collections.shuffle(list);
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int s = list.get(i);
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
        Collections.sort(A);
        Collections.sort(B);
        Collections.sort(C);
        Collections.sort(dipai);
        look(map,A);
        look(map,B);
        look(map,C);
        look(map,dipai);
    }
    public static void look(HashMap<Integer,String> map,ArrayList<Integer> list){
        for (int a1 :map.keySet()){
            for (Integer a : list) {
                if(a==a1){
                    System.out.print(map.get(a)+" ");
                }
            }
        }
        System.out.println();
    }
}
