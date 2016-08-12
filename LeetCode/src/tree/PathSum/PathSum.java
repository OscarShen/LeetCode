package tree.PathSum;

import tree.binaryTreePreoderTraversal.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		return pathFind(root, sum);
	}

	private boolean pathFind(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			if (sum - root.val == 0) {
				return true;
			}
		}
		return pathFind(root.left, sum - root.val) || pathFind(root.right, sum - root.val);
	}
}
