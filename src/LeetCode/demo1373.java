package LeetCode;
//⼆叉搜索⼦树的最⼤键值和
public class demo1373 {
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        travel(root);
        return ans;
    }
    public int[] travel(TreeNode root){
        if(root==null)return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        int[] res = new int[4];
        int[] left = travel(root.left);
        int[] right = travel(root.right);
        if(left[0]==1&&right[0]==1&&root.val>left[2]&&root.val<right[1]){
            res[0] = 1;
            res[1] = Math.min(root.val,left[1]);
            res[2] = Math.max(root.val,right[2]);
            res[3] = root.val+left[3]+right[3];
            ans = Math.max(ans,res[3]);
        }
        return res;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
