package LeetCode;
//最大二叉树
public class demo654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0, nums.length - 1);
    }
    public TreeNode build(int[] nums,int hi,int ho){
        if(hi>ho){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if(max<nums[i]){
                max = nums[i];
                index=i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, hi, index - 1);
        root.right = build(nums, index+1, ho);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
