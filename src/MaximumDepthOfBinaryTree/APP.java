package maximumDepthOfBinaryTree;

import binaryTreePreoderTraversal.TreeNode;

public class APP {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(-1);
		TreeNode n7 = new TreeNode(5);
		TreeNode n9 = new TreeNode(6);
		TreeNode n10 = new TreeNode(8);
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n3.left=n5;
		n3.right=n6;
		n4.left=n7;
		n4.right=n9;
		n5.right=n9;
		n6.right=n10;
		
		System.out.println(new MaximumDepthOfBinaryTree2().maxDepth(n1));
	}
}
