package LeetCode;
//230. 二叉搜索树中第K小的元素
public class demo230 {
    int res = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return 0;
        kthSmallest(root.left,k);
        count++;
        if(k==count){
            res = root.val;
        }
        kthSmallest(root.right,k);
        return  res;
    }
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
