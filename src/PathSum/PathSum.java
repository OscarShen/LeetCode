package PathSum;

import BinaryTreePreoderTraversal.TreeNode;

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

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.right = n2;
		n2.right = n3;

		System.out.println(new PathSum().hasPathSum(n1, 6));
	}

}
