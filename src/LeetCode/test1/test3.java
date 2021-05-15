package LeetCode.test1;

import java.util.ArrayList;
import java.util.List;

public class test3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (int i = 0; i < list.size()-2; i+=2){
            list.add(list.get(i)+list.get(i+1));
        }
        System.out.println(list.toString());
        //System.out.println(sumOfAdjacentElements(list));
    }
    public static int sumOfAdjacentElements(List<Integer> array) {
        int sum = 0;
        int count = array.size()/2;
        if(array.size()<=2){
            for(int a:array){
                sum+=a*a;
            }
            return sum;
        }else {
            for (int j = 0; j < count; j++) {
                for (int i = 0; i < array.size()-2; i+=2){
                    array.add(array.get(i)+array.get(i+1));
                }
            }
        }
        return 1;
    }
}
