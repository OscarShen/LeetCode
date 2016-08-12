package tree.binaryTreePreoderTraversal;

import java.util.Iterator;
import java.util.List;

public class APP {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.right = n2;
		n2.right = n3;

		System.out.println("=======�������=========");
		PreOrder pre = new PreOrder();
		List<Integer> l = pre.preorderTraversal(n1);
		Iterator<Integer> it = l.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("=========�������=======");
		MidOrder mid = new MidOrder();
		l = mid.midorderTraversal(n1);
		it = l.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
