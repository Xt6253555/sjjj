package LeetCode;
//从中序与后序遍历序列构造二叉树
public class demo106 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart>inEnd || postStart>postEnd){
            return null;
        }
        int index =0;
        TreeNode root = new TreeNode(postorder[postEnd]);
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==postorder[postEnd]){
                index=i;
                break;
            }
        }
        int leftSize = index-inStart;
        root.left = build(inorder,inStart,index-1,
                postorder,postStart,postStart+leftSize-1);
        root.right = build(inorder,index+1,inEnd,
                postorder,postStart+leftSize,postEnd-1);
        return root;
    }
}
