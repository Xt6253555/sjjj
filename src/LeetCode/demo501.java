package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//501. 二叉搜索树中的众数
public class demo501 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        l1.right = new TreeNode(1);
        l1.right.right = new TreeNode(2);
        l1.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(findMode(l1)));
    }
    public static int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = find(root);
        for (int i = 0; i < res.size(); i++) {
            if(map.containsKey(res.get(i))) {
                map.put(res.get(i), map.get(res.get(i))+1);
            }else {
                map.put(res.get(i), 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int val = 0;
        for(Integer a: map.keySet()){
            if(max<= map.get(a)){
                max= map.get(a);
                val = a;
            }
        }
        list.add(val);
        map.remove(val);
        for(Integer a: map.keySet()){
            if(max== map.get(a)){
                list.add(a);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static List<Integer> find(TreeNode root){
        if (root == null)return list;
        list.add(root.val);
        find(root.left);
        find(root.right);
        return list;
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
