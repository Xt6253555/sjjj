package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;

//1361. 验证二叉树
public class demo1361 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        list.add(1);
        list.add(1);
        for (Integer integer : list) {
            set.add(integer);
        }
        System.out.println(set.toString());
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < leftChild.length; i++) {
            if(leftChild[i]!=-1){
                list.add(leftChild[i]);
            }
        }
        for (int i = 0; i < rightChild.length; i++) {
            if(rightChild[i]!=-1){
                list.add(rightChild[i]);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer a : list) {
            set.add(a);
        }
        if(set.size() == n-1){
            return true;
        }
        return false;
    }
}
