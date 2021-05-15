package JOffice;
//重建二叉树
public class demo11 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,
        inorder,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,
                              int[] inorder,int inStart,int inpreEnd){
        if(preStart>preEnd||inStart>inpreEnd)return null;
        int index = 0;
        int rootVal = preorder[0];
        for (int i = inStart; i <= inpreEnd; i++) {
            if(inorder[i]==rootVal){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index-inStart;
        root.left = buildTree(preorder,preStart+1,preStart+leftSize,
                inorder,inStart,index-1);
        root.right =buildTree(preorder,preStart+leftSize+1,preEnd,
                inorder,index+1,inpreEnd) ;
        return root;
    }
}
