package LeetCode;
//从前序与中序遍历序列构造二叉树
public class demo105 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==preorder[preStart]){
                index = i;
            }
        }
        int leftsize = index-inStart;
        root.left = build(preorder,preStart+1,preStart+leftsize,
                inorder,inStart,index-1);
        root.right = build(preorder,preStart+1+leftsize,preEnd,
                inorder,index+1,inEnd);
        return root;
    }
}
