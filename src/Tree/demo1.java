package Tree;


import java.util.ArrayList;

public class demo1 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list1.add(list);
        }
        System.out.println(list1.toString());
    }
}
