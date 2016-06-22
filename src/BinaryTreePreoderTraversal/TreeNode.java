package BinaryTreePreoderTraversal;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.right = t2;
		t2.right = t3;
		TreeNode t = t1;
		t.right = null;
		do {
			System.out.print(t.val);
			t = t.right;
		} while (t != null);
		System.out.println("============");
		do {
			System.out.println(t1.val);
			t1 = t1.right;
		} while (t1 != null);
	}
}
