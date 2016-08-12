package tree.binaryTreePreoderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MidOrder {
	public List<Integer> midorderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode temp=root;
		while(temp!=null || !stack.isEmpty()){
			while(temp!=null){
				stack.push(temp);
				temp=temp.left;
			}
			if(!stack.isEmpty()){
				temp=stack.pop();
				list.add(temp.val);
				temp=temp.right;
			}
		}
		return list;
	}
}
