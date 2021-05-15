package LeetCode;
//437. 路径总和 III
public class demo437 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)return 0;
        return count(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    public int count(TreeNode root,int sum){
        if (root == null)return 0;
        int count = 0;
        sum-=root.val;
        if(sum==0){
            count++;
        }
        return count+count(root.left,sum)+count(root.right,sum);
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
