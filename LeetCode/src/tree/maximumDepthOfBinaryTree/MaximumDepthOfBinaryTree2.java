package tree.maximumDepthOfBinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

import tree.binaryTreePreoderTraversal.TreeNode;

public class MaximumDepthOfBinaryTree2 {
	public int maxDepth(TreeNode root) {
		int deep = 0;
		Queue<TreeNode> q = new ArrayDeque<>();
		if(root==null){
		    return deep;
		}
		q.offer(root);
		while (!q.isEmpty()) {
			deep++;
			int n = q.size();
			for (int i = 0; i < n; i++) {
				TreeNode temp = q.poll();
				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
			}
		}

		return deep;
	}
}
