package convertSortedArrayToBinarySearchTree;

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return null;
		}
		if (n == 1) {
			return new TreeNode(nums[0]);
		}
		int mid = (n + 1) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		int[] leftNums = new int[mid];
		System.arraycopy(nums, 0, leftNums, 0, mid);
		root.left = sortedArrayToBST(leftNums);

		int[] rightNums = new int[n - 1 - mid];
		System.arraycopy(nums, mid + 1, rightNums, 0, n - 1 - mid);
		root.right = sortedArrayToBST(rightNums);
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
