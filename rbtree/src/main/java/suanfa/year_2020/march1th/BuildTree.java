package suanfa.year_2020.march1th;

import suanfa.year_2020.may31.TreeNode;

/**
 * @auther eleme
 * @time 2020/6/1 11:22 下午
 * @desc
 */
public class BuildTree {
    public static void main(String[] args) {
        BuildTree client = new BuildTree();


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //先找根节点
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //先找根节点
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }

        //构建节点
        TreeNode node = new TreeNode(preorder[preStart]);

        //再分割
        node.left = buildTreeHelper(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index);
        node.right = buildTreeHelper(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);
        return node;
    }
}
