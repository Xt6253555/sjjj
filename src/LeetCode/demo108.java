package LeetCode;

import javax.xml.stream.events.EndDocument;

//108. 将有序数组转换为二叉搜索树
public class demo108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)return null;
        return sortedArrayToBST(nums,0, nums.length);
    }
    public TreeNode sortedArrayToBST(int[] nums,int left ,int right){
        if(left>right)return null;
        int mid = (left+right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        if(left == right) return node;
        node.left = sortedArrayToBST(nums,left,mid-1);
        node.right = sortedArrayToBST(nums,mid+1,right);
        return node;
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
