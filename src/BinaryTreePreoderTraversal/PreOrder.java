package binaryTreePreoderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root == null) {
			return list;
		}
		
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode temp = stack.peek();
			list.add(temp.val);
			stack.pop();
			if(temp.right!=null){
				stack.push(temp.right);
			}
			if(temp.left!=null){
				stack.push(temp.left);
			}
		}
		return list;
	}
}