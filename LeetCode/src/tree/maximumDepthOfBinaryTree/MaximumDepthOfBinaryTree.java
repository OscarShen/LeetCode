package tree.maximumDepthOfBinaryTree;

import tree.binaryTreePreoderTraversal.TreeNode;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        int deep;
        if(root == null){
            return 0;
        }
        int leftDeep=maxDepth(root.left);
        int rightDeep=maxDepth(root.right);
        deep= leftDeep>=rightDeep? leftDeep+1:rightDeep+1;
        return deep;
    }
}
